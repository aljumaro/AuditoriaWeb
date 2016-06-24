package com.aljumaro.auditoria.configuration.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Date 24/06/2016
 * @Time 16:30
 * @Author Juanma
 */
@Component
public class RestUnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        SecurityUtils.sendError(httpServletResponse, e, HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
    }
}
