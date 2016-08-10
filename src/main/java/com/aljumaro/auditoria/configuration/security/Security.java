package com.aljumaro.auditoria.configuration.security;

import com.aljumaro.auditoria.configuration.Constants;
import com.aljumaro.auditoria.configuration.security.RestAccessDeniedHandler;
import com.aljumaro.auditoria.configuration.security.RestAuthenticationFailureHandler;
import com.aljumaro.auditoria.configuration.security.RestAuthenticationSuccessHandler;
import com.aljumaro.auditoria.configuration.security.RestUnauthorizedEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import static com.aljumaro.auditoria.configuration.Constants.Path;
import static com.aljumaro.auditoria.configuration.Constants.Path.withAllSubPath;

/**
 * @Date 24/06/2016
 * @Time 16:04
 * @Author Juanma
 */
@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    public static final String JSESSIONID_COOKIE = "JSESSIONID";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    @Autowired
    private RestUnauthorizedEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;

    @Autowired
    private RestAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private RestAuthenticationFailureHandler authenticationFailureHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers(Path.IGNORE_SECURITY_RESOURCES);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().disable().csrf().disable()
                .authorizeRequests()
                .antMatchers(Constants.Path.FAILURE).permitAll()
                .antMatchers(withAllSubPath(Constants.Path.USER)).hasAnyAuthority(Constants.Authority.ADMIN)
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .accessDeniedHandler(restAccessDeniedHandler)
                .and()
                .formLogin()
                .loginProcessingUrl(Constants.Path.AUTHENTICATE)
                .usernameParameter(USERNAME)
                .passwordParameter(PASSWORD)
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl(Constants.Path.LOGOUT)
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                .deleteCookies(JSESSIONID_COOKIE)
                .permitAll()
                .and()
                .rememberMe();

    }
}
