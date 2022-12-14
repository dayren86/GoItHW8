package com.HWSpring.GoItDevHW8.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class DefaultSecurityConfig {
    private final CustomAuthenticationProvider authenticationProvider;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/manufacturer/*").hasAnyAuthority("admin")
                .antMatchers("/products/*").hasAnyAuthority("admin")
                .antMatchers("/users/*").hasAnyAuthority("admin")
                .antMatchers("/roles/*").hasAnyAuthority("admin")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Autowired
    public void injectCustomAuthProvider(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}