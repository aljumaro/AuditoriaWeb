package com.aljumaro.auditoria.cucumber.atm.example.domain;

import org.springframework.stereotype.Component;

/**
 * @Date 05/07/2016
 * @Time 20:07
 * @Author Juanma
 */
public class CashSlot {

    private Amount amount = new Amount(0, 0);

    public Amount getContents(){
        return amount;
    }

    public void dispense(Amount amount) {
        this.amount = amount;
    }
}
