package com.example.MySecondTestAppSpringBoot.exception;

public class UnsupportedCodeException extends Exception {
    public UnsupportedCodeException() {
        super("uid не может быть равен \"123\"");
    }
}