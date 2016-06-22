package com.aljumaro.auditoria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date 21/06/2016
 * @Time 19:21
 * @Author Juanma
 */
@Controller
@RequestMapping("/")
public class ApplicationController {

    @RequestMapping
    public String basePage(){
        return "index";
    }
}
