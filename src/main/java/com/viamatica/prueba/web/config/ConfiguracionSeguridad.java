package com.viamatica.prueba.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ConfiguracionSeguridad{
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()).cors().disable()
                .sessionManagement(httpSecuritySessionManagementConfigurer -> {
                    httpSecuritySessionManagementConfigurer
                            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                            .maximumSessions(1);
                })
                .authorizeHttpRequests(customizeRequests -> {
                    customizeRequests
                            .requestMatchers(HttpMethod.GET, "/usuarios").hasAnyRole("ADMIN", "")
                            .requestMatchers(HttpMethod.PUT, "/usuarios").hasAnyRole("ADMIN", "")
                            .requestMatchers(HttpMethod.POST, "/usuarios").hasAnyRole("ADMIN", "")
                            .requestMatchers(HttpMethod.DELETE, "/usuarios").hasAnyRole("ADMIN", "")
                            .anyRequest()
                            .authenticated();
                })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
