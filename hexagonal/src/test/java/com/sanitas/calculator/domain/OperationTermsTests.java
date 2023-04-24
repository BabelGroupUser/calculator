package com.sanitas.calculator.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OperationTermsTests {

    @Test
    void TermsExistsGivenNullValueAsTerms() {
        OperationTerms operationTerms = new OperationTerms(null);
        assertNotNull(operationTerms.getTerms());
        assertTrue(operationTerms.getTerms().isEmpty());
    }

    @Test
    void TermsExistsGivenTermsSetAsNull() {
        List<Integer> terms = getTwoTermsAsListOfIntegers();
        OperationTerms operationTerms = new OperationTerms(terms);
        operationTerms.setTerms(null);
        assertNotNull(operationTerms.getTerms());
        assertTrue(operationTerms.getTerms().isEmpty());
    }

    private static List<Integer> getTwoTermsAsListOfIntegers() {
        List<Integer> terms = new ArrayList<>();
        terms.add(2);
        terms.add(3);
        return terms;
    }

    @Test
    void TermsExistsAsEmptyList() {
        OperationTerms operationTerms = new OperationTerms();
        assertNotNull(operationTerms.getTerms());
        assertTrue(operationTerms.getTerms().isEmpty());
    }
}
