package com.sms.me.realworld.core.cache;

import com.sms.me.realworld.core.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Getter
@AllArgsConstructor
@Slf4j
@SuppressWarnings({"unchecked"})
public enum CacheSpec {
    USER_BY_ID("userById", Duration.ofDays(365L), User.class),
    USER_BY_USERNAME("userByUsername", Duration.ofDays(365L), User.class),
    ;

    private static final String SEPARATOR = ":";
    private final String prefix;
    private final Duration ttl;
    private final Class<?> clazz;

    /*
     * id 값으로 key 값을 생성한다.
     */
    public String generateKey(Object id) {
        return this.prefix + SEPARATOR + id.toString();
    }

    /*
     * Class 타입을 반환한다.
     */
    public <T> Class<T> getClazz() {
        return (Class<T>) this.clazz;
    }
}
