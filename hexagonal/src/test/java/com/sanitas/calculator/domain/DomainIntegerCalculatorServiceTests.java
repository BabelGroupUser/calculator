package com.sanitas.calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class DomainIntegerCalculatorServiceTests {
    private static final List<Integer> ONE_TERM_LIST = List.of(new Integer[]{1});
    private static final List<Integer> TWO_TERMS_LIST = List.of(new Integer[]{3, 2});
    private static final Integer TWO_TERMS_ADDING_RESULT = 5;
    private static final Integer TWO_TERMS_SUBSTRACTING_RESULT = 1;

    @Mock
    private DomainIntegerCalculatorService service;

    @Mock
    private OperationTerms operationTermsWithNoTerms;

    @Mock
    private OperationTerms operationTermsWithOneTerm;

    @Mock
    private OperationTerms operationTermsWithTwoTerms;

    @BeforeEach
    void init() {
        given(operationTermsWithNoTerms.getTerms()).willReturn(new ArrayList<>());
        given(operationTermsWithOneTerm.getTerms()).willReturn(ONE_TERM_LIST);
        given(operationTermsWithTwoTerms.getTerms()).willReturn(TWO_TERMS_LIST);
        given(service.add(operationTermsWithNoTerms)).willThrow(ResponseStatusException.class);
        given(service.add(operationTermsWithOneTerm)).willReturn(ONE_TERM_LIST.get(0));
        given(service.add(operationTermsWithTwoTerms)).willReturn(TWO_TERMS_ADDING_RESULT);
        given(service.substract(operationTermsWithNoTerms)).willThrow(ResponseStatusException.class);
        given(service.substract(operationTermsWithOneTerm)).willReturn(ONE_TERM_LIST.get(0));
        given(service.substract(operationTermsWithTwoTerms)).willReturn(TWO_TERMS_SUBSTRACTING_RESULT);
    }

    @Test
    void AddingNullListOfTerms() {
        assertTrue(service.add(null) == 0);
    }

    @Test
    void addingListOfNoTerms() {
        assertThrows(ResponseStatusException.class, () -> service.add(operationTermsWithNoTerms));
    }

    @Test
    void AddingListOfOneTermGivesOneTermBack() {
        assertEquals(ONE_TERM_LIST.get(0), service.add(operationTermsWithOneTerm));
    }

    @Test
    void AddingListOfTwoTerms() {
        assertEquals(TWO_TERMS_ADDING_RESULT, service.add(operationTermsWithTwoTerms));
    }

    @Test
    void SubstractingNullListOfTerms() {
        assertTrue(service.substract(null) == 0);
    }

    @Test
    void substractingListOfNoTerms() {
        assertThrows(ResponseStatusException.class, () -> service.substract(operationTermsWithNoTerms));
    }

    @Test
    void SubstractingListOfOneTermGivesOneTermBack() {
        assertEquals(ONE_TERM_LIST.get(0), service.substract(operationTermsWithOneTerm));
    }

    @Test
    void SubstractingListOfTwoTerms() {
        assertEquals(TWO_TERMS_SUBSTRACTING_RESULT, (int) service.substract(operationTermsWithTwoTerms));
    }
}
