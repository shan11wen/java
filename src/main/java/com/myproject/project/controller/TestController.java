package com.myproject.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @description:
 * @author: xiongshanwen
 * @create: 2021-05-21 15:30
 **/
@RestController
@RequestMapping("/demo")
public class TestController {

    @RequestMapping("/test")
    public String test() {
        System.out.println("success = " + "success");
        return "success";
    }


}
