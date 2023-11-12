package com.example.MySecondTestAppSpringBoot.controller;


import com.example.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import com.example.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import com.example.MySecondTestAppSpringBoot.model.*;
import com.example.MySecondTestAppSpringBoot.service.DeltaTime;
import com.example.MySecondTestAppSpringBoot.service.ModifyResponseService;
import com.example.MySecondTestAppSpringBoot.service.UnsupportedService;
import com.example.MySecondTestAppSpringBoot.service.ValidationService;
import com.example.MySecondTestAppSpringBoot.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final UnsupportedService unsupportedService;
    private final ModifyResponseService modifyResponseService;


    @Autowired
    public MyController(ValidationService validationService, UnsupportedService unsupportedService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService) {

        this.validationService = validationService;
         this.unsupportedService = unsupportedService;
        this.modifyResponseService = modifyResponseService;
    }

    @PostMapping( value = "/feedback")
    public ResponseEntity<Response> feedback (@Valid @RequestBody Request request,
                                              BindingResult bindingResult){


        log.info("request {}", request);



        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        log.info("request {}", request);
        DeltaTime.delta(request,response);
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
            } catch (Exception e) {
                response.setCode(Codes.FAILED);
                response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTIONS);
                response.setErrorMessage(ErrorMessages.UNKNOWN);
                log.info("response {}", response);
                log.error("Exception", e);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            modifyResponseService.modify(response);
        log.info("request {}", request);
        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);

    }

}
