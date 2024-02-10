package com.sms.me.realworld.core.config.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class TokenPropertiesTest {

    @Autowired
    public TokenProperties properties;

    @Test
    void propertiesTest() {
        log.info("secret = {}", properties.secret);
        log.info("duration = {}", properties.duration);
    }


}