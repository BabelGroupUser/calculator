package com.sanitas.calculator.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SimpleCalculatorRestControllerTestsMVC {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addingReturnsInteger() throws Exception {
        this.mockMvc.perform(callPostRequestForAddingTwoTerms())
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(3));
    }

    RequestBuilder callPostRequestForAddingTwoTerms() {
        return post("/simplecalculator/integer/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(Charset.defaultCharset())
                .content("{ \"operationTerms\" : { \"terms\" : [1, 2] } } ");
    }

    @Test
    void addingWithNullRequestReturnsBadRequestError() throws Exception {
        this.mockMvc.perform(callPostRequestForAddingNoTerms())
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    RequestBuilder callPostRequestForAddingNoTerms() {
        return post("/simplecalculator/integer/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(Charset.defaultCharset())
                .content("{ \"operationTerms\" : {} } ");
    }

    @Test
    void substractingReturnsInteger() throws Exception {
        this.mockMvc.perform(callPostRequestForSubstractingUsingTwoTerms())
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1));
    }

    RequestBuilder callPostRequestForSubstractingUsingTwoTerms() {
        return post("/simplecalculator/integer/substract")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(Charset.defaultCharset())
                .content("{ \"operationTerms\" : { \"terms\" : [3, 2] } } ");
    }

    @Test
    void substractingWithNullRequestReturnsBadRequestError() throws Exception {
        this.mockMvc.perform(callPostRequestForSubstractingUsingNoTerms())
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    RequestBuilder callPostRequestForSubstractingUsingNoTerms() {
        return post("/simplecalculator/integer/substract")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(Charset.defaultCharset())
                .content("{ \"operationTerms\" : {} } ");
    }

}
