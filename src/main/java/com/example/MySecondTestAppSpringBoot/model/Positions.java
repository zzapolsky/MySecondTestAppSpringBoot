package com.example.MySecondTestAppSpringBoot.model;

import lombok.Getter;

@Getter
public enum Positions {

    DEV(2.2, false),
    HR(1.2, false),
    TL(2.6, true),
    QA(2.1, false), // обеспечение качества
    TM(2.5, true), // тим лид
    CPA(1.8, false); // сертифицированный бухгалтер

    private final double positionCoefficient;
    private final boolean isItManager;


    Positions(double positionCoefficient, boolean isItManager){
        this.positionCoefficient = positionCoefficient;
        this.isItManager = isItManager;
    }

}
