package com.example.MyThirdTestAppSpringBoot.service;

import com.example.MyThirdTestAppSpringBoot.exception.UnsupportedCodeException;
import org.springframework.stereotype.Service;
import com.example.MyThirdTestAppSpringBoot.model.Request;
@Service
public interface UnsupportedService {
    void unsupported(Request request) throws UnsupportedCodeException;
}
