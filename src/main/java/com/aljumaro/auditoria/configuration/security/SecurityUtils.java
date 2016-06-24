package com.aljumaro.auditoria.configuration.security;

import com.aljumaro.auditoria.controller.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.aljumaro.auditoria.controller.dto.Error;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Date 24/06/2016
 * @Time 16:32
 * @Author Juanma
 */
public class SecurityUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static void sendError(HttpServletResponse response, Exception e, int status,
                                 String message) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(status);
        PrintWriter pw = response.getWriter();
        Error error = new Error("authError", e.getMessage());
        pw.write(objectMapper.writeValueAsString(new Response(status, message, error)));
        pw.flush();
        pw.close();
    }

    public static void sendResponse(HttpServletResponse response, int status, Object obj) throws IOException{
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(status);
        PrintWriter pw = response.getWriter();
        pw.write(objectMapper.writeValueAsString(obj));
        pw.flush();
        pw.close();

    }

    public static String getCurrentLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserDetails userDetails = null;
        String userName = null;

        if(authentication != null) {
            if(authentication.getPrincipal() instanceof UserDetails) {
                userDetails = (UserDetails) authentication.getPrincipal();
                userName = userDetails.getUsername();
            } else if (authentication.getPrincipal() instanceof String) {
                userName = (String) authentication.getPrincipal();
            }
        }

        return userName;
    }
}
