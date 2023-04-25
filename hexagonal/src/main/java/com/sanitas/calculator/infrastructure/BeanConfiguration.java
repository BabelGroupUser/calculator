package com.sanitas.calculator.infrastructure;

import com.sanitas.calculator.CalculatorApplication;
import com.sanitas.calculator.domain.DomainIntegerCalculatorService;
import com.sanitas.calculator.domain.IntegerCalculatorService;
import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CalculatorApplication.class)
public class BeanConfiguration {
    @Bean
    IntegerCalculatorService integerCalculatorService() {
        return new DomainIntegerCalculatorService(TracerImpl());
    }

    @Bean
    TracerImpl TracerImpl() {
        return new TracerImpl();
    }

}