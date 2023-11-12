package com.example.MySecondTestAppSpringBoot.service;

import com.example.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import org.springframework.stereotype.Service;
import com.example.MySecondTestAppSpringBoot.model.Request;
@Service
public interface UnsupportedService {
    void unsupported(Request request) throws UnsupportedCodeException;
}
