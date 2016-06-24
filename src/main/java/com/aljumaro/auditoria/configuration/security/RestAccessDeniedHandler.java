package com.aljumaro.auditoria.configuration.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Date 24/06/2016
 * @Time 16:52
 * @Author Juanma
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {
        SecurityUtils.sendError(httpServletResponse, e, HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized resources");
    }
}
