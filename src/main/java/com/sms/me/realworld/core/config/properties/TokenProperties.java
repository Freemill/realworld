package com.sms.me.realworld.core.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties("token")
@Getter
@AllArgsConstructor
public class TokenProperties {
    public final String secret;
    public final Duration duration;

}
