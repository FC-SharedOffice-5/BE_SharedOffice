package com.FC.SharedOfficePlatform.global.security;


import com.FC.SharedOfficePlatform.global.security.enums.AuthorityCode;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private static final String SECRET_KEY = "secret_key";
    private static final Duration ACCESS_DURATION = Duration.of(1, ChronoUnit.DAYS);

    public String issueAccessToken(Long id, String email, AuthorityCode authorityCode) {
        return JWT.create()
            .withSubject(String.valueOf(id))
            .withClaim("email", email)
            .withClaim("authorityCode", List.of(authorityCode.name()))
            .withExpiresAt(Instant.now().plus(ACCESS_DURATION))
            .sign(Algorithm.HMAC256(SECRET_KEY));
    }
}
