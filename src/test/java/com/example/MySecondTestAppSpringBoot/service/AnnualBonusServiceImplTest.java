package com.example.MySecondTestAppSpringBoot.service;

import com.example.MySecondTestAppSpringBoot.model.Positions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
class AnnualBonusServiceImplTest {

    @Test
    void calculate() {

        //given
        Positions positions = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;
        //when
        double result = new AnnualBonusServiceImpl().calculate(positions, salary, bonus, workDays);
        //then
        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }
}