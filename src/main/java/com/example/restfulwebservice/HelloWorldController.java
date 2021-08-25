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
}
