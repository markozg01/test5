package com.example.demo.test

import com.github.tomakehurst.wiremock.WireMockServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig

@Configuration
class WireMockServerConfig {

    @Bean
    @Autowired(required = false)
    WireMockServer createWireMock(){
        new WireMockServer(
                wireMockConfig()
                .port(9209)
               )
    }
}
