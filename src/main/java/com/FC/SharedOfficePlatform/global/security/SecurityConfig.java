package com.FC.SharedOfficePlatform.global.security;

import com.FC.SharedOfficePlatform.global.security.jwt.JwtFilter;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final CustomMemberDetailsService customMemberDetailsService;
    private final UnauthorizedHandler unauthorizedHandler;

    @Bean
    public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {

        http.cors(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS))
            .formLogin(AbstractHttpConfigurer::disable)
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

            .exceptionHandling(
                exceptionHandling -> exceptionHandling
                    .authenticationEntryPoint(unauthorizedHandler)
            )
            .securityMatcher("/**")
            .authorizeHttpRequests(
                authorize -> authorize
                    /*.requestMatchers(HttpMethod.POST, "/members/signup").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/members/update/pw/{id}").permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/email/send/code").permitAll()
                    .requestMatchers(HttpMethod.GET, "/email/**").permitAll()
                    .requestMatchers(HttpMethod.POST,"/qrcode/validate").permitAll()*/
                    .requestMatchers(new AntPathRequestMatcher("/members/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/email/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/qrcode/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/businesses/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/notices/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/mypage/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/offices/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/schedules/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/images/**")).permitAll()
                    .anyRequest().authenticated()
            );
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customMemberDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


