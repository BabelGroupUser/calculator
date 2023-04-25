package com.sanitas.calculator.application;

import com.sanitas.calculator.application.mapper.OperationTermsMapper;
import com.sanitas.calculator.domain.IntegerCalculatorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.openapitools.model.SimpleCalculatorRequest;
import org.openapitools.model.SimpleCalculatorRequestOperationTerms;
import org.openapitools.model.SimpleCalculatorResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SimpleCalculatorRestControllerTests {

    @Mock
    private NativeWebRequest request;
    @Mock
    private IntegerCalculatorService service;
    @Mock
    private OperationTermsMapper mapper;

    @InjectMocks
    private SimpleCalculatorRestController controller;

    @Test
    void addingReturnsInteger() {
        SimpleCalculatorRequest simpleCalculatorRequest = new SimpleCalculatorRequest();
        SimpleCalculatorRequestOperationTerms operationTerms = new SimpleCalculatorRequestOperationTerms();
        simpleCalculatorRequest.setOperationTerms(operationTerms);
        SimpleCalculatorResponse simpleCalculatorResponse = new SimpleCalculatorResponse();
        simpleCalculatorResponse.setResult(0);
        ResponseEntity<SimpleCalculatorResponse> responseEntity = ResponseEntity.ok(simpleCalculatorResponse);
        assertEquals(responseEntity, controller.add(simpleCalculatorRequest));
    }

    @Test
    void addingWithNullRequestReturnsBadRequestError() {
        assertThrows(ResponseStatusException.class, () -> controller.add(null));
    }

    @Test
    void substractingReturnsInteger() {
        SimpleCalculatorRequest simpleCalculatorRequest = new SimpleCalculatorRequest();
        SimpleCalculatorRequestOperationTerms operationTerms = new SimpleCalculatorRequestOperationTerms();
        simpleCalculatorRequest.setOperationTerms(operationTerms);
        SimpleCalculatorResponse simpleCalculatorResponse = new SimpleCalculatorResponse();
        simpleCalculatorResponse.setResult(0);
        ResponseEntity<SimpleCalculatorResponse> responseEntity = ResponseEntity.ok(simpleCalculatorResponse);
        assertEquals(responseEntity, controller.substract(simpleCalculatorRequest));
    }

    @Test
    void substractingWithNullRequestReturnsBadRequestError() {
        assertThrows(ResponseStatusException.class, () -> controller.substract(null));
    }

}
