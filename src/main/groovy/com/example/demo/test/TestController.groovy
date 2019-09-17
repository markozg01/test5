package com.example.demo.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController(value = "testApp")
class TestController {

    @GetMapping(value = "/test2")
    void test(){

    }
}
