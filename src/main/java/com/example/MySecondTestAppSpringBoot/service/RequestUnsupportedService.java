package com.example.MySecondTestAppSpringBoot.service;

import com.example.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import org.springframework.stereotype.Service;

import com.example.MySecondTestAppSpringBoot.model.Request;
@Service
public class RequestUnsupportedService implements UnsupportedService {

    @Override
    public void unsupported(Request request) throws UnsupportedCodeException {
        if (request.getUid().equals("123")) {
            throw new UnsupportedCodeException();
        }
    }
}