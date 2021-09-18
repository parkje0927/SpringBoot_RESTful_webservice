package com.example.restfulwebservice.helloworld;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final MessageSource messageSource;

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

    /**
     * 다국어 Internationalization
     */
    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
