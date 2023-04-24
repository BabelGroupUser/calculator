package com.sanitas.calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OperationTerms {
    List<Integer> terms;

    public OperationTerms() {
        this.terms = new ArrayList<>();
    }

    public OperationTerms(List<Integer> terms) {
        setTerms(terms);
    }

    public List<Integer> getTerms() {
        return terms;
    }

    public void setTerms() {
        this.terms = new ArrayList<>();
    }

    public void setTerms(List<Integer> terms) {
        if (terms == null) {
            terms = new ArrayList<>();
        }
        this.terms = terms.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
