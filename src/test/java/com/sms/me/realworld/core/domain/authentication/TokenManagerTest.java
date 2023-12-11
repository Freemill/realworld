package com.sms.me.realworld.core.domain.authentication;

import com.sms.me.realworld.core.config.properties.TokenProperties;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TokenManagerTest {

    private TokenManager tokenManager = new TokenManager(new TokenProperties("secretsecretsecretsecretsecretsecretsecretsecret", Duration.ofDays(365)));

    /*
    eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJyZWFsd29ybGQiLCJzdWIiOiIxIiwicm9sZSI6IlJPTEVfVVNFUiIsImV4cCI6MTczMzgzNTEyMH0.pYY7wJNM9OEzKEi4xJkNPp0HL7u4qZnSznE5nGYlpLM
     */

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