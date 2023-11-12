package com.example.MySecondTestAppSpringBoot.service;

import com.example.MySecondTestAppSpringBoot.model.Positions;
import org.springframework.stereotype.Service;


@Service
public class QuarterlyBonusService implements QuarterlyBonus{
    @Override
    public double calculate(double salary, Positions positions, double bonus, int workDays) {
        if (positions.isItManager()) {

            return ((salary * bonus * LeapYear.leapYearOrNot() * positions.getPositionCoefficient() / workDays)
                    * 0.1);
        } else return 0.0;
    }
}