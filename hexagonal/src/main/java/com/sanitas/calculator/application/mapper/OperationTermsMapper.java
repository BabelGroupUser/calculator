package com.sanitas.calculator.application.mapper;

import com.sanitas.calculator.domain.OperationTerms;
import org.mapstruct.Mapper;
import org.openapitools.model.SimpleCalculatorRequestOperationTerms;

@Mapper(componentModel = "spring")
public interface OperationTermsMapper {
    SimpleCalculatorRequestOperationTerms getRequestOperationTerms(OperationTerms operationTerms);
    OperationTerms getDomainOperationTerms(SimpleCalculatorRequestOperationTerms operationTerms);
}
