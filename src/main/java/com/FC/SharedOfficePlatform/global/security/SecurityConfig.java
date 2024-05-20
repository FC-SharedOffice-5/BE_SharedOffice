package com.FC.SharedOfficePlatform.global.security;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] ALLOWED_SPECIFIC_URL = {
        // 예시 -> "/signup/**", "/login/**"
    };

    private final MemberDetailsService memberDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /* JWT is STATELESS tokens
         CSRF attacks rely on the browser's ability to send cookies to a different origin, which JWTs
         mitigate by not relying on cookies for authentication */
        http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagement -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
        ;

        http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
            .requestMatchers(
                Arrays.stream(ALLOWED_SPECIFIC_URL)
                    .map(AntPathRequestMatcher::new)
                    .toArray(RequestMatcher[]::new)
            ).permitAll()
            .requestMatchers(
                new AntPathRequestMatcher("/signup", HttpMethod.POST.name()),
                new AntPathRequestMatcher("/login", HttpMethod.POST.name())
            ).permitAll()
            .anyRequest().authenticated()
        );

        return http.build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider () {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(memberDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

}



/*     Before using WIHTE_LIST_URL = {} ;
-----------------------
    @Bean
    public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {

        http.cors(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS))
            .formLogin(AbstractHttpConfigurer::disable)
            .securityMatcher("/**")
            .authorizeHttpRequests(
                registry -> registry
                    .requestMatchers("/signup", "/login").permitAll()
                    .anyRequest().authenticated()
            );
        return http.build();
    }

    @Bean
    public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS))
            .formLogin(AbstractHttpConfigurer::disable)
            .securityMatcher("/**")
            .authorizeHttpRequests(
                req -> req.requestMatchers(WHITE_LITT_URL) //  // Add the white-listed URLs
                     .permitAll()
                    .anyRequest()
                    .authenticated()
            );
        return http.build();
    }



 */
