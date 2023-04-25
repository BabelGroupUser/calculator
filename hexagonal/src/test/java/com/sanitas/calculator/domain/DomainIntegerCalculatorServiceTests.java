package com.sanitas.calculator.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class DomainIntegerCalculatorServiceTests {
    @Mock
    private DomainIntegerCalculatorService service;

    @Test
    void addingListOfNoTerms() {
        OperationTerms operationTermsWithNoTerms = new OperationTerms(null);
        given(service.add(operationTermsWithNoTerms)).willThrow(ResponseStatusException.class);
        assertThrows(ResponseStatusException.class, () -> service.add(operationTermsWithNoTerms));
    }

    @Test
    void addingListOfOneTermGivesOneTermBack() {
        List<Integer> oneTermList = List.of(new Integer[]{1});
        OperationTerms operationTermsWithOneTerm = new OperationTerms(oneTermList);
        given(service.add(operationTermsWithOneTerm)).willReturn(oneTermList.get(0));
        assertEquals(oneTermList.get(0), service.add(operationTermsWithOneTerm));
    }

    @Test
    void addingListOfTwoTerms() {
        List<Integer> twoTermsList = List.of(new Integer[]{3, 2});
        OperationTerms operationTermsWithTwoTerms = new OperationTerms(twoTermsList);
        Integer twoTermsAddingResult = 5;
        given(service.add(operationTermsWithTwoTerms)).willReturn(twoTermsAddingResult);
        assertEquals(twoTermsAddingResult, service.add(operationTermsWithTwoTerms));
    }

    @Test
    void subtractingListOfNoTerms() {
        OperationTerms operationTermsWithNoTerms = new OperationTerms();
        given(service.subtract(operationTermsWithNoTerms)).willThrow(ResponseStatusException.class);
        assertThrows(ResponseStatusException.class, () -> service.subtract(operationTermsWithNoTerms));
    }

    @Test
    void subtractingListOfOneTermGivesOneTermBack() {
        List<Integer> oneTermList = List.of(new Integer[]{1});
        OperationTerms operationTermsWithOneTerm = new OperationTerms(oneTermList);
        given(service.subtract(operationTermsWithOneTerm)).willReturn(oneTermList.get(0));
        assertEquals(oneTermList.get(0), service.subtract(operationTermsWithOneTerm));
    }

    @Test
    void subtractingListOfTwoTerms() {
        List<Integer> twoTermsList = List.of(new Integer[]{3, 2});
        OperationTerms operationTermsWithTwoTerms = new OperationTerms(twoTermsList);
        Integer twoTermsSubtractionResult = 1;
        given(service.subtract(operationTermsWithTwoTerms)).willReturn(twoTermsSubtractionResult);
        assertEquals(twoTermsSubtractionResult, service.subtract(operationTermsWithTwoTerms));
    }
}
