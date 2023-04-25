package com.sanitas.calculator.application;

import com.sanitas.calculator.application.mapper.OperationTermsMapper;
import com.sanitas.calculator.controllers.DefaultApiDelegate;
import com.sanitas.calculator.domain.IntegerCalculatorService;
import com.sanitas.calculator.domain.OperationTerms;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/simplecalculator")
public class SimpleCalculatorRestController implements DefaultApiDelegate {
    private NativeWebRequest request;
    @Autowired
    private IntegerCalculatorService integerCalculatorService;
    @Autowired
    private OperationTermsMapper mapper;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<SimpleCalculatorResponse> add(final SimpleCalculatorRequest calculatorRequest) {
        try {
            OperationTerms operationTerms = mapper.getDomainOperationTerms(calculatorRequest.getOperationTerms());
            Integer result = integerCalculatorService.add(operationTerms);
            return getResponseEntity(result);
        } catch (Exception e) {
            String reason = getExceptionReason(calculatorRequest);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, reason);
        }
    }

    @Override
    public ResponseEntity<SimpleCalculatorResponse> subtract(final SimpleCalculatorRequest calculatorRequest) {
        try {
            OperationTerms operationTerms = mapper.getDomainOperationTerms(calculatorRequest.getOperationTerms());
            Integer result = integerCalculatorService.subtract(operationTerms);
            return getResponseEntity(result);
        } catch (Exception e) {
            String reason = getExceptionReason(calculatorRequest);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, reason);
        }
    }

    private ResponseEntity<SimpleCalculatorResponse> getResponseEntity(Integer result) {
        SimpleCalculatorResponse simpleCalculatorResponse = new SimpleCalculatorResponse();
        simpleCalculatorResponse.setResult(result);
        return ResponseEntity.ok(simpleCalculatorResponse);
    }

    private String getExceptionReason(SimpleCalculatorRequest calculatorRequest) {
        if (calculatorRequest == null || calculatorRequest.getOperationTerms() == null) {
            return "Request body is malformed";
        }
        return "Request terms are not numbers";
    }

}
