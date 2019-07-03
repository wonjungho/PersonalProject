package com.practice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeContoller
 */
@Controller
public class HomeContoller {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    
}