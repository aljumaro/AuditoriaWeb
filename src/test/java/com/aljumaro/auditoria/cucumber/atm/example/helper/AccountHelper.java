package com.aljumaro.auditoria.cucumber.atm.example.helper;

import com.aljumaro.auditoria.cucumber.atm.example.domain.Account;
import com.aljumaro.auditoria.cucumber.atm.example.domain.CashSlot;
import com.aljumaro.auditoria.cucumber.atm.example.domain.Teller;
import org.springframework.stereotype.Component;

/**
 * @Date 05/07/2016
 * @Time 20:02
 * @Author Juanma
 */
@Component
public class AccountHelper {

    private Account account;
    private CashSlot cashSlot;
    private Teller teller;

    public Account getAccount() {
        if (account == null) {
            account = new Account();
        }

        return account;
    }

    public CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }

        return cashSlot;
    }

    public Teller getTeller() {
        if (teller == null) {
            teller = new Teller(getCashSlot());
        }

        return teller;
    }
}
