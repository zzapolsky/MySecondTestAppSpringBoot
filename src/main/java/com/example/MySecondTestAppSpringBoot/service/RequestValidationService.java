package com.example.MySecondTestAppSpringBoot.service;

import com.example.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
@Service
public class RequestValidationService implements ValidationService{


    public void isValid(BindingResult bindingResult) throws ValidationFailedException{

        if (bindingResult.hasErrors()){
            throw new
                    ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }

}
