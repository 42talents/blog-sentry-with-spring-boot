package com.fortytwotalents.sentrysampleapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ExceptionController {

    @GetMapping("/")
    String hello(@RequestParam String name, @RequestParam boolean triggerException) {
        log.info("I am about to trigger an exception: {}", triggerException);

        if (triggerException == true) {
            throw new RuntimeException("Expected: controller used to showcase what happens when an exception is thrown");
        }
        return "Hello " + name.toUpperCase();
    }
}