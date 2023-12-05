package com.sms.me.realworld.core.domain.authentication;

import com.sms.me.realworld.core.config.properties.TokenProperties;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TokenManagerTest {

    private TokenManager tokenManager = new TokenManager(new TokenProperties("secretsecretsecretsecretsecretsecretsecretsecret", Duration.ofMinutes(10)));

    @Test
    void generateTest() {
        String token = tokenManager.generateToken(1L);
        System.out.println(token);
        assertNotNull(token);
    }

    @Test
    void parseToken() {

/*        //given
        Long userId = 123L;
        String token = tokenManager.generateToken(userId);

        //when
        Claims claims = tokenManager.getAuthentication(token);

        //then
        assertEquals(userId.toString(), claims.getSubject());*/
    }

}