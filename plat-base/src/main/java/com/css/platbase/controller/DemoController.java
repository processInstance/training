package com.css.platbase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lin
 * @date : 21:03 2021/8/17
 */
@RestController
@RequestMapping("/base")
public class DemoController {

    @GetMapping("/getUser")
    public String getUser(){
        return "test";
    }
}
