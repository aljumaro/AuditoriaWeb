package com.aljumaro.auditoria.controller;

import com.aljumaro.auditoria.configuration.security.SecurityUtils;
import com.aljumaro.auditoria.domain.user.User;
import com.aljumaro.auditoria.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 24/06/2016
 * @Time 17:47
 * @Author Juanma
 */
@RestController()
public class SecurityController {

    @Autowired
    private UserService userService;

    @RequestMapping("/security/account")
    public @ResponseBody User getUserAccount(@AuthenticationPrincipal User activeUser) {
        return activeUser;
    }
}
