package com.my.workout.datediff.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DateDifferenceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenValidInputThenReturns200() throws Exception {
        mockMvc
                .perform( get( "/api/date/difference" )
                                  .param( "startDate", "1983-06-02" )
                                  .param( "endDate", "1983-06-22" ) )
                .andExpect( status().isOk() );
    }

    @Test
    void whenValidInputThenReturns400() throws Exception {
        mockMvc
                .perform( get( "/api/date/difference" )
                                  .param( "startDate", "1983-06-021" )
                                  .param( "endDate", "1983-06-22" ) )
                .andExpect( status().isBadRequest() )
                .andExpect(jsonPath( "$.message" ).value(  " Start Date '1983-06-021' is not valid. "))
                .andExpect(jsonPath( "$.type" ).value(  "Invalid input param."))
                .andExpect(jsonPath( "$.errorCode" ).value(  "400 BAD_REQUEST"))
                .andExpect(jsonPath( "$.status" ).value(  "ERROR"));

    }

    @Test
    void whenValidInputThenReturnsResponse() throws Exception {
        mockMvc
                .perform( get( "/api/date/difference" )
                                  .param( "startDate", "1983-06-02" )
                                  .param( "endDate", "1983-06-22" ) )
                .andExpect( status().isOk() )
                .andExpect(jsonPath( "$.startDate" ).value(  "1983-06-02"))
                .andExpect(jsonPath( "$.endDate" ).value(  "1983-06-22"))
                .andExpect(jsonPath( "$.difference" ).value(  "19"));
    }
}
