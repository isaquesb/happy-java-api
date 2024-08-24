package com.github.isaquesb.happy_java_api.domain.common.validation.rules;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class OneOfTwoValidator implements ConstraintValidator<OneOfTwo, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(OneOfTwo constraintAnnotation) {
        this.firstFieldName = constraintAnnotation.firstField();
        this.secondFieldName = constraintAnnotation.secondField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Field firstField = value.getClass().getDeclaredField(firstFieldName);
            Field secondField = value.getClass().getDeclaredField(secondFieldName);

            firstField.setAccessible(true);
            secondField.setAccessible(true);

            Object firstValue = firstField.get(value);
            Object secondValue = secondField.get(value);

            if (firstValue != null && secondValue != null) {
                return true;
            }

            return !(firstValue == null && secondValue == null);

        } catch (Exception e) {
            return false;
        }
    }
}
