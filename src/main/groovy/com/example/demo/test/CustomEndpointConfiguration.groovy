package com.example.demo.test

import org.springframework.boot.actuate.autoconfigure.ManagementContextConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.context.annotation.Bean

@ManagementContextConfiguration
class CustomEndpointConfiguration {

    @Bean
    @ConditionalOnBean(TestEndpoint.class)
    TestMvcEnpoint construct(TestEndpoint delegate){
        new TestMvcEnpoint(delegate)
    }
}
