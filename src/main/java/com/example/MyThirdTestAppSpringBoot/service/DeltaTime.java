package com.example.MyThirdTestAppSpringBoot.service;

import com.example.MyThirdTestAppSpringBoot.model.Request;
import com.example.MyThirdTestAppSpringBoot.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class DeltaTime {
    public static void delta(Request request, Response response) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String strDateRequest = request.getSystemTime();
        String strDateResponse = response.getSystemTime();
        try {
            Date dateRequest = simpleDateFormat.parse(strDateRequest);
            Date dateResponse = simpleDateFormat.parse(strDateResponse);

            long difference = dateResponse.getTime() - dateRequest.getTime();

            log.info("Разница во времени составляет {}", difference);
        } catch (Exception e) {
            log.error("Ошибка в расчете разницы времени", e);
        }
    }

}
