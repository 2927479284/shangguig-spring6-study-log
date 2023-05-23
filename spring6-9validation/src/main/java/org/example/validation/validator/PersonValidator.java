package org.example.validation.validator;

import org.example.validation.domain.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import java.lang.annotation.Annotation;

public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    /**
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Person p = (Person) target;
        if (p.getAge() < 0) {
            errors.rejectValue("age", "年龄不能小于0");
        } else if (p.getAge() > 110) {
            errors.rejectValue("age", "年龄不能大于110");
        }
    }
}
