package com.sanitas.calculator.application.mapper;

import com.sanitas.calculator.domain.OperationTerms;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.SimpleCalculatorRequestOperationTerms;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTermsMapperTests {
    private OperationTermsMapper mapper = Mappers.getMapper(OperationTermsMapper.class);

    @Test
    public void givenDomainOperationTerms_whenMaps_thenCorrect() {
        OperationTerms operationTerms = new OperationTerms();
        operationTerms.setTerms(Arrays.asList(1, 2));
        SimpleCalculatorRequestOperationTerms destinationTerms = mapper.getRequestOperationTerms(operationTerms);
        assertEquals(operationTerms.getTerms().size(), destinationTerms.getTerms().size());
        assertEquals(operationTerms.getTerms().get(0), destinationTerms.getTerms().get(0));
        assertEquals(operationTerms.getTerms().get(1), destinationTerms.getTerms().get(1));
    }

    @Test
    public void givenRequestOperationTerms_whenMaps_thenCorrect() {
        SimpleCalculatorRequestOperationTerms requestOperationTerms = new SimpleCalculatorRequestOperationTerms();
        requestOperationTerms.setTerms(Arrays.asList(1, 2));
        OperationTerms operationTerms = mapper.getDomainOperationTerms(requestOperationTerms);
        assertEquals(requestOperationTerms.getTerms().size(), operationTerms.getTerms().size());
        assertEquals(requestOperationTerms.getTerms().get(0), operationTerms.getTerms().get(0));
        assertEquals(requestOperationTerms.getTerms().get(1), operationTerms.getTerms().get(1));
    }
}
