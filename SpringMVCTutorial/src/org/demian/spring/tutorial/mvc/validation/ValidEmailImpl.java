package org.demian.spring.tutorial.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.EmailValidator;

public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {

	public void initialize(ValidEmail constraintAnnotation) {
	}

	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (EmailValidator.getInstance(false).isValid(email))
			return true;
		else
			return false;
	}
}