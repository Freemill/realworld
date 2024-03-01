package com.sms.me.realworld.core.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.me.realworld.core.exception.ErrorType;
import com.sms.me.realworld.core.exception.RealException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CommonRedisTemplate {
    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;

    /*
     * 데이터를 레디스에 저장한다.
     */
    public <V> V set(Object id, V value, CacheSpec cacheSpec) {
        try {
            String json = objectMapper.writeValueAsString(value);
            redisTemplate.opsForValue().set(cacheSpec.generateKey(id), json, cacheSpec.getTtl());
        } catch (JsonProcessingException e) {
            throw new RealException(ErrorType.INTERNAL_SERVER_ERROR);
        }
        return value;
    }

    /*
     * 데이터를 레디스에서 가져온다.
     */
    public <T> T get(Object id, CacheSpec cacheSpec) {
        String json = redisTemplate.opsForValue().get(cacheSpec.generateKey(id));
        if (StringUtils.isNotBlank(json)) {
            try {
                return objectMapper.readValue(json, cacheSpec.getClazz());
            } catch (JsonProcessingException e) {
                throw new RealException(ErrorType.INTERNAL_SERVER_ERROR);
            }
        }
        return null;
    }

    /*
     * 데이터를 레디스에서 지운다.
     */
    public boolean delete(Object id, CacheSpec cacheSpec) {
        try {
            String key = cacheSpec.generateKey(id);
            return Boolean.TRUE.equals(redisTemplate.delete(key));
        } catch (NullPointerException e) {
            throw new RealException(ErrorType.INTERNAL_SERVER_ERROR);
        }
    }
}
