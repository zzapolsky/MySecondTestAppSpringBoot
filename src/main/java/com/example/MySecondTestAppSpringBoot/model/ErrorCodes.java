package com.example.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {

    EMPTY(""),
    VALIDATION_EXCEPTION("ValidationException"),
    UNKNOWN_EXCEPTIONS("UnknownException"),
    UNSUPPORTED_EXCEPTIONS("UnsupportedException");

    private final String name;

    ErrorCodes(String name){
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
