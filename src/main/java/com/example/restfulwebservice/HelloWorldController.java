package com.example.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    /**
     * endpoint : /hello-world
     * GET
     */
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    /**
     * 객체를 반환할 경우, JSON type 으로 return 됨.
     * {"message":"Hello World"}
     */
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }
}
