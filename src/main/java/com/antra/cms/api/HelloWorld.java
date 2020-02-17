package com.antra.cms.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    // when user hit the endpoint, print "Hello world"
    @RequestMapping(value="/hello")
    public String sayHello(){
        return "Hello World, this is my Spring Boot practice.";
    }
}
