package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec.
                pathMatchers("/js/**",
                                 "/css/**",
                                 "/img/**",
                                 "/pdf/**",
                                 "/pdfjs/**",
                                 "/fonts/**",
                                 "/register",
                                 "/login",
                                 "/books/**",
                                 "/collect/**",
                                 "/favicon.ico",
                                 "/v3/api-docs/**",
                                 "/swagger-ui.html",
                                 "/swagger-ui/**",
                                 "/timeout",
                                 "/defaultfallback",
                                 "/").permitAll().anyExchange().authenticated()
                .and().headers().frameOptions().disable())
            .oauth2Login(Customizer.withDefaults());
//        http.authorizeExchange().anyExchange().permitAll();
        http.csrf().disable();
        return http.build();
    }
}
