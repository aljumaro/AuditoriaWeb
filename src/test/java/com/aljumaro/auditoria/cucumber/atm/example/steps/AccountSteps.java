package com.aljumaro.auditoria.cucumber.atm.example.steps;

import com.aljumaro.auditoria.cucumber.TestConfiguration;
import com.aljumaro.auditoria.cucumber.atm.example.domain.Amount;
import com.aljumaro.auditoria.cucumber.atm.example.converter.AmountConverter;
import com.aljumaro.auditoria.cucumber.atm.example.helper.AccountHelper;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

@ContextConfiguration(classes = {TestConfiguration.class})
public class AccountSteps {

	private AccountHelper helper;

	@Resource
	public void setHelper(AccountHelper helper) {
		this.helper = helper;
	}

	@Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
	public void i_have_deposited_$_in_my_account(@Transform(AmountConverter.class) Amount amount) throws Throwable {
		helper.getAccount().deposit(amount);
        Assert.assertEquals("Incorrect account balance", amount, helper.getAccount().getBalance());
	}

}
