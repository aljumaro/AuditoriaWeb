package com.aljumaro.auditoria.cucumber.atm.example.domain;

import org.springframework.stereotype.Component;

/**
 * @Date 05/07/2016
 * @Time 19:46
 * @Author Juanma
 */
public class Teller {

    private CashSlot cashSlot;

    public Teller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account account, Amount amount) {
        account.withdraw(amount);
        cashSlot.dispense(amount);
    }
}
