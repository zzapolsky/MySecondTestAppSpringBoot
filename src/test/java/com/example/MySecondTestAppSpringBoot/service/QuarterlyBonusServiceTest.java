package com.example.MySecondTestAppSpringBoot.service;

import com.example.MySecondTestAppSpringBoot.model.Positions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QuarterlyBonusServiceTest {

    @Test
    void calculate() {
        Positions positions = Positions.TL;
        double salary = 100000.00;
        double bonus = 2;
        int workDays = 243;
        double result = new  QuarterlyBonusService().calculate(salary, positions, bonus, workDays);

        double expected = 78106.99588477366;
        assertThat(result).isEqualTo(expected);
    }
}