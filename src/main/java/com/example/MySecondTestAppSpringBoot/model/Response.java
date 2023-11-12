package com.example.MySecondTestAppSpringBoot.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Response {
    /*
    Уникальный идентификатор сообщения
    */
    private String uid;
    /*
    Уникальный идентификатор операции
    */
    private String operationUid;
    /*
    Время создания сообщения
    */
    private String systemTime;
    /*
    Состояние ответа
    */
    private Codes code;
    /*
    Годовая премия
    */
    private Double quarterlyBonus;
    /*
    Код ошибки
    */
    private ErrorCodes errorCode;
    /*
    Сообщение об ошибке
    */
    private ErrorMessages errorMessage;

}
