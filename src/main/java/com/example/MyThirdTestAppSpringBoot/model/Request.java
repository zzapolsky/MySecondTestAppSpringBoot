package com.example.MyThirdTestAppSpringBoot.model;


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

    @NotBlank(message = "Поле не может быть пустым")
    @Size(max =32, message = "Поле uid не должно превышать 32 символа")
    private String uid;


    @NotBlank(message = "Поле не может быть пустым")
    @Size(max =32, message = "Поле operationUid не должно превышать 32 символа")
    private String operationUid;

    private String systemName;
    @NotBlank(message = "Поле не может быть пустым")
    private String systemTime;

    private String source;
    @Min(value =1, message = "Поле communicationUid не может быть меньше 1")
    @Max(value =100000, message = "Поле communicationUid не может быть больше 100000")
    private int communicationId;

    private int templateId;
    private int productCode;
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

