package com.sanitas.calculator.domain;

import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class DomainIntegerCalculatorService implements IntegerCalculatorService {
    private final TracerImpl tracer;

    @Autowired
    public DomainIntegerCalculatorService(TracerImpl tracer) {
        this.tracer = tracer;
    }

    @Override
    public Integer add(final OperationTerms operationTerms) {
        List<Integer> terms = operationTerms == null ? new ArrayList<>() : operationTerms.getTerms();
        Integer result = getAddingResult(terms);
        tracer.trace(result);
        return result;
    }

    private Integer getAddingResult(final List<Integer> terms) {
        if (terms.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No terms found in the operation");
        }
        if (terms.size() == 1) {
            return terms.get(0);
        }
        return terms.stream()
                .reduce(Integer::sum)
                .get();
    }

    @Override
    public Integer subtract(final OperationTerms operationTerms) {
        List<Integer> terms = operationTerms == null ? new ArrayList<>() : operationTerms.getTerms();
        Integer result = getSubtractingResult(terms);
        tracer.trace(result);
        return result;
    }

    private Integer getSubtractingResult(final List<Integer> terms) {
        if (terms.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No terms found in the operation");
        }
        if (terms.size() == 1) {
            return terms.get(0);
        }
        return terms.stream()
                .reduce((first, second) -> first - second)
                .get();
    }
}
