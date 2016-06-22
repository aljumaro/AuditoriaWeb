package com.aljumaro.auditoria.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date 21/06/2016
 * @Time 19:21
 * @Author Juanma
 */
@Controller
@RequestMapping("/")
public class ApplicationController implements ErrorController{

    private final static String ERROR_PATH = "/error";

    @Value("${profileName}")
    private String profileName;

    @RequestMapping
    public String basePage(Model model){
        model.addAttribute("profileName", profileName);
        return "index";
    }

    @RequestMapping(ERROR_PATH)
    public String errorPage(){ return "error"; }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
