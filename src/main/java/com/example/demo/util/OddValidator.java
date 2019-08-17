package com.example.demo.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

 public class OddValidator implements ConstraintValidator<Odd,Integer> {
    @Override
    public void initialize(Odd constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        return age % 2 != 0;
    }
}
