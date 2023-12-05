package com.sms.me.realworld.core.domain.authentication;

import com.sms.me.realworld.api.security.AuthUserDetails;
import com.sms.me.realworld.core.config.properties.TokenProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@Component
public class TokenManager {
    private static final String ISSUER = "realworld";
    private static final String ROLE = "role";

    private final TokenProperties tokenProperties;
    private final SecretKey secretKey;
    private final JwtParser jwtParser;


    public TokenManager(TokenProperties tokenProperties) {
        this.tokenProperties = tokenProperties;

        secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(tokenProperties.secret));
        jwtParser = Jwts.parser()
                .requireIssuer(ISSUER)
                .verifyWith(secretKey)
                .build();
    }

    public String generateToken(Long userId) {
        Date expiration = Date.from(Instant.now().plus(tokenProperties.duration));

        return Jwts.builder()
                .issuer(ISSUER)
                .subject(userId.toString())
                .claim(ROLE, RoleType.USER)
                .expiration(expiration)
                .signWith(secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Jws<Claims> jws = jwtParser.parseSignedClaims(token);
        Claims claims = jws.getPayload();

        Long userId = Long.parseLong(claims.getSubject());
        RoleType roleType = RoleType.valueOf(claims.get(ROLE, String.class));

        AuthUserDetails principal = AuthUserDetails.of(userId, roleType);

        return UsernamePasswordAuthenticationToken.authenticated(
                principal,
                "",
                principal.getAuthorities());

    }
}
