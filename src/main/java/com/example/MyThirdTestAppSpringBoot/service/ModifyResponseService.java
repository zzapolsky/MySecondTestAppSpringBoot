package com.example.MyThirdTestAppSpringBoot.service;

import com.example.MyThirdTestAppSpringBoot.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
