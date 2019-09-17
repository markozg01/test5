package com.example.demo.test

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import wslite.rest.RESTClient

@Component
@Slf4j
class CodebookCache {

    private RESTClient client

    @Autowired
    CodebookCache(){
        client = new RESTClient('test')
    }

    def testMethod(def requestParhVariable){
        log.info(requestParhVariable)
        def response = client.get(path:"/${URLEncoder.encode(requestParhVariable, 'UTF-8')}")?.json
        log.info("RESPONSE OK")
    }
}
