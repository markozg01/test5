package com.example.demo.test;

import groovy.lang.Closure;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
class TestEndpoint extends AbstractEndpoint {

    public Closure invocationMethod;

    TestEndpoint() {
        super("test", false, true);
    };

    @Override
    public Object invoke(){
        if(invocationMethod != null){
            return invocationMethod.call();
        }

        Map<String, Boolean> returnMap = new HashMap<>();
        returnMap.put("succes", false);
        returnMap.put("result", null);
        return returnMap;
    }
}
