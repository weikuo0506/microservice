package com.walker.microservice.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by walker on 2017/4/11.
 */
@RestController
@CrossOrigin
public class SimpleController {
    @RequestMapping(method = RequestMethod.GET,path = "/hello")
    public String hello() {
        return "hello world";
    }
}
