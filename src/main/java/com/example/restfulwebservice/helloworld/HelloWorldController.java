package com.example.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.HelloWorld;

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

    /**
     * Path Variable
     */
    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
