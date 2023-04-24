package com.sanitas.calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class DomainIntegerCalculatorService implements IntegerCalculatorService {

    @Override
    public Integer add(final OperationTerms operationTerms) {
        List<Integer> terms = operationTerms == null ? new ArrayList<>() : operationTerms.getTerms();
        if (terms.isEmpty()) {
            return 0;
        }
        if (terms.size() == 1) {
            return terms.get(0);
        }
        return terms.stream()
                .reduce(Integer::sum)
                .get();
    }

    @Override
    public Integer substract(final OperationTerms operationTerms) {
        List<Integer> terms = operationTerms == null ? new ArrayList<>() : operationTerms.getTerms();
        if (terms.isEmpty()) {
            return 0;
        }
        if (terms.size() == 1) {
            return terms.get(0);
        }
        return terms.stream()
                .reduce((first, second) -> first - second)
                .get();
    }
}
