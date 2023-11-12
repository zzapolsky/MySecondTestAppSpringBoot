package com.example.MySecondTestAppSpringBoot.controller.response;

import com.example.MySecondTestAppSpringBoot.model.*;
import com.example.MySecondTestAppSpringBoot.service.QuarterlyBonus;
import com.example.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;

public class ResponseController {
    public static Response resp(Request request, QuarterlyBonus quarterlyBonus) {
        return Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .quarterlyBonus(quarterlyBonus.calculate(request.getSalary(), Positions.TL, request.getBonus(), request.getWorkDays()))
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();


    }
}
