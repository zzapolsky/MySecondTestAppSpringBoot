package com.example.MySecondTestAppSpringBoot.controller.exception;

import com.example.MySecondTestAppSpringBoot.controller.response.ResponseController;
import com.example.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import com.example.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import com.example.MySecondTestAppSpringBoot.model.*;
import com.example.MySecondTestAppSpringBoot.service.UnsupportedService;
import com.example.MySecondTestAppSpringBoot.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

@Slf4j
public class Exception {
    public static ResponseEntity<Response> exception(ValidationService validationService,
                                                     UnsupportedService unsupportedService,
                                                     BindingResult bindingResult, Request request, Response response) {
        try {
            validationService.isValid(bindingResult);
            unsupportedService.unsupported(request);
        }
        catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.info("response {}", response);
            log.error("ValidationFailedException", e);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.UNSUPPORTED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTIONS);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.info("response {}", response);
            log.error("UnsupportedCodeException", e);
            System.err.println(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (java.lang.Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTIONS);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.info("response {}", response);
            log.error("Exception", e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return null;

    }

}