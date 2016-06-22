package com.aljumaro.auditoria.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
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

    @RequestMapping
    public String basePage(){
        return "index";
    }

    @RequestMapping(ERROR_PATH)
    public String errorPage(){ return "error"; }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
