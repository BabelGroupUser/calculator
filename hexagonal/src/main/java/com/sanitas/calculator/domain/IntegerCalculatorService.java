package com.sanitas.calculator.domain;

import com.sanitas.calculator.domain.operations.IntegerAddition;
import com.sanitas.calculator.domain.operations.IntegerSubtraction;

public interface IntegerCalculatorService extends IntegerAddition, IntegerSubtraction {
}
