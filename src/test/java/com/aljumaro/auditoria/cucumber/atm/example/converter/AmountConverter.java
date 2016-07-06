package com.aljumaro.auditoria.cucumber.atm.example.converter;

import com.aljumaro.auditoria.cucumber.atm.example.domain.Amount;
import cucumber.api.Transformer;

/**
 * @Date 04/07/2016
 * @Time 19:30
 * @Author Juanma
 */
public class AmountConverter extends Transformer<Amount> {

    @Override
    public Amount transform(String value) {

        String[] numbers = value.split("\\.");

        int whole = Integer.parseInt(numbers[0]);
        int fraction = Integer.parseInt(numbers[1]);

        return new Amount(whole, fraction);
    }
}
