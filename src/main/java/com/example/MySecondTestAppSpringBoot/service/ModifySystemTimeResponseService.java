package com.example.MySecondTestAppSpringBoot.service;


import com.example.MySecondTestAppSpringBoot.controller.response.ResponseController;
import com.example.MySecondTestAppSpringBoot.model.Response;
import com.example.MySecondTestAppSpringBoot.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {

    @Override
    public Response modify(Response response) {

        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

        return response;
    }
}
