package com.example.MySecondTestAppSpringBoot.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Request {

    /*
    Уникальный идентификатор сообщения
     */

    @NotBlank(message = "Поле не может быть пустым")
    @Size(max =32, message = "Поле uid не должно превышать 32 символа")
    private String uid;

    /*
    Уникальный идентификатор операции
    */
    @NotBlank(message = "Поле не может быть пустым")
    @Size(max =32, message = "Поле operationUid не должно превышать 32 символа")
    private String operationUid;
    /*
    Имя системы отправителя
    */
    private String systemName;
    /*
    Время создания сообщения
    */
    @NotBlank(message = "Поле не может быть пустым")
    private String systemTime;
    /*
    Имя источника
    */
    private String source;
    /*
    Коэффициент должности
    */
    private Positions position;
    /*
    Оплата труда
    */
    private double salary;
    /*
    Коэффициент оплаты труда
    */
    private double bonus;
    /*
    Количество рабочих дней
    */
    private Integer workDays;
    /*
    Комуникационный идентификатор
    */
    @Min(value =1, message = "Поле communicationUid не может быть меньше 1")
    @Max(value =100000, message = "Поле communicationUid не может быть больше 100000")
    private int communicationId;
    /*
    Идентификатор шаблона
    */
    private int templateId;
    /*
    Код продукта
    */
    private int productCode;
    /*
    SMS код
    */
    private int smsCode;

    @Override
    public String toString() {
        return "Request{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}

