package com.aljumaro.auditoria.cucumber.atm.example.domain;

import org.springframework.stereotype.Component;

/**
 * @Date 01/07/2016
 * @Time 20:23
 * @Author Juanma
 */
public class Amount {

    private int whole;
    private int fraction;

    public Amount(int whole, int fraction) {
        this.whole = whole;
        this.fraction = fraction;

        correctWhole();

    }

    public void add(Amount other) {

        this.whole += other.whole;
        this.fraction += other.fraction;

        correctWhole();
    }

    public void subtract(Amount amount) {
        this.whole -= amount.whole;
        this.fraction -= amount.fraction;

        if (fraction < 0) {
            fraction += 100;
            whole--;
        }
    }

    private void correctWhole() {
        if (fraction >= 100) {
            fraction -= 100;
            whole++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        if (whole != amount.whole) return false;
        return fraction == amount.fraction;

    }

    @Override
    public int hashCode() {
        int result = whole;
        result = 31 * result + fraction;
        return result;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "whole=" + whole +
                ", fraction=" + fraction +
                '}';
    }
}
