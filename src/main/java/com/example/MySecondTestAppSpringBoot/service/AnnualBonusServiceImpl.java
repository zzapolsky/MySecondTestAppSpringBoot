package com.example.MySecondTestAppSpringBoot.service;


import com.example.MySecondTestAppSpringBoot.model.Positions;
import org.springframework.stereotype.Service;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{

    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        return salary * bonus * LeapYear.leapYearOrNot() * positions.getPositionCoefficient() / workDays;
    }
}
