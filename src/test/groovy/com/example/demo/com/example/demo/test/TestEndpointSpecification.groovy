package com.example.demo.com.example.demo.test

import com.example.demo.BaseIntegrationSpecification
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.endpoint.mvc.ActuatorMediaTypes
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import spock.lang.Shared

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.http.HttpStatus.OK


import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

class TestEndpointSpecification extends BaseIntegrationSpecification{

    @Autowired
    WebApplicationContext webApplicationContext

    @Shared
    MockMvc mockMvc

    def setup() {
        if(!mockMvc){
            mockMvc = webAppContextSetup(webApplicationContext).build()
        }
    }


    def 'test'(){
        when:
        //TODO ovo gađa pravi app context od aplikacije
        def response = mockMvc.perform(post('/service-diagnostics/test/reinitializeTest?testName=22')
        .accept(MediaType.APPLICATION_JSON)
        .contentType(ActuatorMediaTypes.APPLICATION_ACTUATOR_V1_JSON_VALUE))
        .andReturn()
        .response

        def content = new JsonSlurper().parseText(response.contentAsString) as Map
        then:
        response.status == OK.value()
        content.success == true
        content.result
    }


}
