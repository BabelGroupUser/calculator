package com.sanitas.calculator.domain;

import com.sanitas.calculator.domain.operations.IntegerAddition;
import com.sanitas.calculator.domain.operations.IntegerSubstraction;

public interface IntegerCalculatorService extends IntegerAddition, IntegerSubstraction {
}
