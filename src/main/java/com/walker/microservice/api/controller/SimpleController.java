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
    @RequestMapping(name="helloService", method = RequestMethod.GET,path = "/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping(name="hiService", method = RequestMethod.GET,path = "/hi")
    public String hi() {
        return "Hi, how are you?";
    }
}
