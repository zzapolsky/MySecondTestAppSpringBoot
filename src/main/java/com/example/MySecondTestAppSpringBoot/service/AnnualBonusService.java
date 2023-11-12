package com.example.MySecondTestAppSpringBoot.service;

import com.example.MySecondTestAppSpringBoot.model.Positions;

public interface AnnualBonusService {

    double calculate(Positions positions, double salary, double bonus, int workDays);
}
