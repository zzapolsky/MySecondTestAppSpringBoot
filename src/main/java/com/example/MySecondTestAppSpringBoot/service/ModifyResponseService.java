package com.example.MySecondTestAppSpringBoot.service;

import com.example.MySecondTestAppSpringBoot.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
