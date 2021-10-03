package com.css.trainmember.controller;

import com.css.trainmember.rpc.DemoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lin
 * @date : 21:03 2021/8/17
 */
@RestController
@RequestMapping("/member")
public class DemoController {
    @Autowired
    DemoFeignService demoFeignService;
    @GetMapping("/getUser")
    public String getUser(){
        String sx=demoFeignService.demoGetUser();
        //离开的理由很多，留下的理由很少
        return sx+"member-test";
    }
}
