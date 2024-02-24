package com.sms.me.realworld.core.config;

import org.assertj.core.api.Assertions;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "jasypt.encryptor.password=password")
class JasyptConfigTest {

    @Autowired
    StringEncryptor jasyptEncryptor;

    @Test
    void jasyptTest() {
        String encrypted = jasyptEncryptor.encrypt("password");
        String decrypted = jasyptEncryptor.decrypt(encrypted);

        Assertions.assertThat("password").isEqualTo(decrypted);
    }


}