package com.aljumaro.auditoria.cucumber.atm.example.domain;

import org.springframework.stereotype.Component;

/**
 * @Date 01/07/2016
 * @Time 20:11
 * @Author Juanma
 */
public class Account {

    private Amount balance = new Amount(0, 0);

    public Account() {
    }

    public void deposit(Amount amount) {
        balance.add(amount);
    }

    public void withdraw(Amount amount) {
        balance.subtract(amount);
    }

    public Amount getBalance(){
        return balance;
    }

}
