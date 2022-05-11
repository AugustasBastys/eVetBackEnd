package com.vilniustech.evet.config;

import com.azure.spring.aad.webapi.AADJwtBearerTokenAuthenticationConverter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    public static final String[] AUTH_WHITELIST = {
            "/vetServices"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .authorizeRequests()
                .antMatchers(SwaggerConfig.SWAGGER_AUTH_WHITELIST).permitAll()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(
                        new AADJwtBearerTokenAuthenticationConverter());

    }

}
