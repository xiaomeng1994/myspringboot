package com.meng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("helloWorld")
public class HelloWorld {

    @RequestMapping("getHelloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }
}
