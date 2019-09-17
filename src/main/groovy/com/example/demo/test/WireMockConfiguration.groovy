package com.example.demo.test

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

//@ConditionalOnProperty(name = 'emaFramework.mockServices.enabled', havingValue = 'true')
@Configuration
@Slf4j
class WireMockConfiguration {

    @Autowired
    private WireMockServer wireMockServer

    @PostConstruct
    void startServer(){
        log.info("START SERVER")
        wireMockServer.start()
        WireMock.configureFor(9209)
    }

    @PreDestroy
    void stopServer(){
        log.info("STOP SERVER")
        wireMockServer.resetRequests()
        wireMockServer.shutdown()
    }
}
