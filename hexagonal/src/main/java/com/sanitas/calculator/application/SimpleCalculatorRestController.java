package com.sanitas.calculator.application;

import com.sanitas.calculator.controllers.DefaultApiDelegate;
import com.sanitas.calculator.domain.IntegerCalculatorService;
import com.sanitas.calculator.domain.OperationTerms;
import io.corp.calculator.TracerImpl;
import org.openapitools.model.SimpleCalculatorRequest;
import org.openapitools.model.SimpleCalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/simplecalculator")
public class SimpleCalculatorRestController implements DefaultApiDelegate {

    private NativeWebRequest request;
    private TracerImpl tracer;
    private IntegerCalculatorService integerCalculatorService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Autowired
    public SimpleCalculatorRestController(TracerImpl tracer, IntegerCalculatorService integerCalculatorService) {
        this.tracer = tracer;
        this.integerCalculatorService = integerCalculatorService;
    }

    @Override
    public ResponseEntity<SimpleCalculatorResponse> add(final SimpleCalculatorRequest calculatorRequest) {
        if (calculatorRequest == null || calculatorRequest.getOperationTerms() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is Empty");
        }
        try {
            OperationTerms operationTerms = new OperationTerms(calculatorRequest.getOperationTerms().getTerms());
            Integer result = integerCalculatorService.substract(operationTerms);
            tracer.trace(result);
            SimpleCalculatorResponse simpleCalculatorResponse = new SimpleCalculatorResponse();
            simpleCalculatorResponse.setResult(result);
            return ResponseEntity.ok(simpleCalculatorResponse);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request terms are not numbers");
        }
    }

    @Override
    public ResponseEntity<SimpleCalculatorResponse> substract(final SimpleCalculatorRequest calculatorRequest) {
        if (calculatorRequest == null || calculatorRequest.getOperationTerms() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is Empty");
        }
        try {
            OperationTerms operationTerms = new OperationTerms(calculatorRequest.getOperationTerms().getTerms());
            Integer result = integerCalculatorService.substract(operationTerms);
            tracer.trace(result);
            SimpleCalculatorResponse simpleCalculatorResponse = new SimpleCalculatorResponse();
            simpleCalculatorResponse.setResult(result);
            return ResponseEntity.ok(simpleCalculatorResponse);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request terms are not numbers");
        }
    }

}
