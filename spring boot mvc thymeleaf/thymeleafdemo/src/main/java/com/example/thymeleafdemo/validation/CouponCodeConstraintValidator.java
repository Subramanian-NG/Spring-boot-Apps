package com.example.thymeleafdemo.validation;

import java.lang.annotation.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CouponCodeConstraintValidator implements ConstraintValidator<CouponCode, String> {

    private String couponPrefix;

    @Override
    public boolean isValid(String inputValue, ConstraintValidatorContext context) {
        if (inputValue != null) {
            if (inputValue.startsWith(couponPrefix))
                return true;
        } else {
            return true;
        }
        return false;
    }

    @Override
    public void initialize(CouponCode constraintAnnotation) {
        couponPrefix = constraintAnnotation.value();
    }

}
