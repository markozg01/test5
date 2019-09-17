package com.example.demo.test

import groovy.util.logging.Slf4j
import org.springframework.boot.actuate.endpoint.mvc.AbstractEndpointMvcAdapter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Slf4j
class TestMvcEnpoint extends AbstractEndpointMvcAdapter<TestEndpoint>{

    TestMvcEnpoint(TestEndpoint testEndpoint){
        super(testEndpoint)
    }

    @PostMapping(value="/reinitializeTest")
    @ResponseBody
    Object test1(@RequestParam String testName){
        log.info(testName)
        [success: true] as Map
    }

    @GetMapping(value="/reinitializeTest2")
    void test2(@RequestParam String testName){
        log.info(testName)
    }
}
