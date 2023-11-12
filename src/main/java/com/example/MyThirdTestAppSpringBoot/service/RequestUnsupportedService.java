package com.example.MyThirdTestAppSpringBoot.service;

import com.example.MyThirdTestAppSpringBoot.exception.UnsupportedCodeException;
import org.springframework.stereotype.Service;

import com.example.MyThirdTestAppSpringBoot.model.Request;
@Service
public class RequestUnsupportedService implements UnsupportedService {

    @Override
    public void unsupported(Request request) throws UnsupportedCodeException {
        if (request.getUid().equals("123")) {
            throw new UnsupportedCodeException();
        }
    }
}