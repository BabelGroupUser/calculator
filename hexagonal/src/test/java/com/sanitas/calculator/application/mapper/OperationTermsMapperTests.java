package com.sanitas.calculator.application.mapper;

import com.sanitas.calculator.domain.OperationTerms;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.SimpleCalculatorRequestOperationTerms;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

class OperationTermsMapperTests {
    private OperationTermsMapper mapper = Mappers.getMapper(OperationTermsMapper.class);

    @Test
    void givenDomainOperationTerms_whenMaps_thenCorrect() {
        OperationTerms operationTerms = new OperationTerms();
        operationTerms.setTerms(Arrays.asList(1, 2));
        SimpleCalculatorRequestOperationTerms destinationTerms = mapper.getRequestOperationTerms(operationTerms);
        assertThat(operationTerms).isEqualToComparingFieldByField(destinationTerms);
    }

    @Test
    void givenRequestOperationTerms_whenMaps_thenCorrect() {
        SimpleCalculatorRequestOperationTerms requestOperationTerms = new SimpleCalculatorRequestOperationTerms();
        requestOperationTerms.setTerms(Arrays.asList(1, 2));
        OperationTerms operationTerms = mapper.getDomainOperationTerms(requestOperationTerms);
        assertThat(operationTerms).hasFieldOrPropertyWithValue("terms", requestOperationTerms.getTerms());
    }
}
