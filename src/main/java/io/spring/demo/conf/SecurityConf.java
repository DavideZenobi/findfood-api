package io.spring.demo.conf;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import io.spring.demo.security.ApplicationAuthenticationProvider;
import io.spring.demo.security.CustomAccessDeniedHandler;

@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {
    
    private final ApplicationAuthenticationProvider applicationAuthenticationProvider;

    public SecurityConf(ApplicationAuthenticationProvider applicationAuthenticationProvider) {
        this.applicationAuthenticationProvider = applicationAuthenticationProvider;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .cors()
            .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
            .and()
            .authorizeRequests()
            .mvcMatchers("/login/me").authenticated()
            .anyRequest().permitAll()
            .and()
                .formLogin().disable()
                .logout().disable();

        
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(applicationAuthenticationProvider);
    }

    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    
}
