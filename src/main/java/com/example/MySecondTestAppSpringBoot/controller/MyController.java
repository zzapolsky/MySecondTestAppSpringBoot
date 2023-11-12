package com.example.MySecondTestAppSpringBoot.controller;


import com.example.MySecondTestAppSpringBoot.model.*;
import com.example.MySecondTestAppSpringBoot.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.MySecondTestAppSpringBoot.controller.response.ResponseController;
import com.example.MySecondTestAppSpringBoot.controller.exception.Exception;

import javax.validation.Valid;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final UnsupportedService unsupportedService;
    private final ModifyResponseService modifyResponseService;
    private final QuarterlyBonus quarterlyBonus;

    @Autowired
    public MyController(ValidationService validationService, UnsupportedService unsupportedService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySourceRequestService") ModifyRequestService modifyRequestService,
                        QuarterlyBonus quarterlyBonus) {

        this.validationService = validationService;
        this.unsupportedService = unsupportedService;
        this.modifyResponseService = modifyResponseService;
        this.quarterlyBonus = quarterlyBonus;

    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                                       BindingResult bindingResult) {


        log.info("request {}", request);
        Response response = ResponseController.resp(request, quarterlyBonus);

        log.info("response {}", response);
        Exception.exception(validationService, unsupportedService, bindingResult, request, response);

        modifyResponseService.modify(response);
        log.info("request {}", request);

        return new ResponseEntity<>(response, HttpStatus.OK);

        

    }
}
