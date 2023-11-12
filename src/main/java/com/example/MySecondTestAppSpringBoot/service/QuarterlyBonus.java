package com.example.MySecondTestAppSpringBoot.service;

import com.example.MySecondTestAppSpringBoot.model.Positions;
import org.springframework.stereotype.Service;

@Service
public interface QuarterlyBonus {
    double calculate(double salary, Positions positions, double bonus, int workDays);

}
