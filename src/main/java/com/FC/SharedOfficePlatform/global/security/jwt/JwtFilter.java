package com.FC.SharedOfficePlatform.global.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

    private static final String ACCESS_TOKEN_COOKIE_NAME = "accessToken";

    private final JwtProvider jwtProvider;

    @Override
    public void doFilter(
        ServletRequest request, ServletResponse response, FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        String accessToken = resolveToken(httpServletRequest);
        if (accessToken == null) {
            chain.doFilter(request, response);
            return;
        }
        // If the token is valid, it retrieves the authentication object and sets it in the SecurityContext.
        if (StringUtils.hasText(accessToken) && jwtProvider.validateToken(accessToken)) {
            Authentication authentication = jwtProvider.getAuthentication(accessToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info(
                "Security Context에 'memberId: {}' 인증 정보를 저장했습니다, uri: {}",
                authentication.getName(), requestURI
            );
        } else {
            log.info("유효한 JWT 토큰이 없습니다, uri: {}", requestURI);
        }
        chain.doFilter(request, response);
    }

    private String resolveToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;

        //iterates through them to find the cookie named accessToken, Returns the value of the accessToken cookie if found.
        for (Cookie cookie : cookies) {
            if (ACCESS_TOKEN_COOKIE_NAME.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
