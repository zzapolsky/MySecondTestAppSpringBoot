package com.example.MySecondTestAppSpringBoot.controller;


import com.example.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import com.example.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import com.example.MySecondTestAppSpringBoot.model.Request;
import com.example.MySecondTestAppSpringBoot.model.Response;
import com.example.MySecondTestAppSpringBoot.service.UnsupportedService;
import com.example.MySecondTestAppSpringBoot.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MyController {

    private final ValidationService validationService;
    private final UnsupportedService unsupportedService;

    @Autowired
    public MyController(ValidationService validationService, UnsupportedService unsupportedService) {

        this.validationService = validationService;
        this.unsupportedService = unsupportedService;
    }

    @PostMapping( value = "/feedback")
    public ResponseEntity<Response> feedback (@Valid @RequestBody Request request,
                                              BindingResult bindingResult){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(simpleDateFormat.format(new Date()))
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
            try {
                validationService.isValid(bindingResult);
                unsupportedService.unsupported(request);
            }
            catch (ValidationFailedException e) {
                response.setCode("failed");
                response.setErrorCode("ValidationException");
                response.setErrorMessage("Ошибка валидации");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } catch (UnsupportedCodeException e) {
                response.setCode("failed");
                response.setErrorCode("UnsupportedException");
                response.setErrorMessage("Ошибка валидации, uid не может быть равен 123");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                response.setCode("failed");
                response.setErrorCode("UnknownException");
                response.setErrorMessage("Произошла непредвиденная ошибка");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
