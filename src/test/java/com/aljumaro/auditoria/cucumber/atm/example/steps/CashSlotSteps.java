package com.aljumaro.auditoria.cucumber.atm.example.steps;

import com.aljumaro.auditoria.cucumber.TestConfiguration;
import com.aljumaro.auditoria.cucumber.atm.example.domain.Amount;
import com.aljumaro.auditoria.cucumber.atm.example.converter.AmountConverter;
import com.aljumaro.auditoria.cucumber.atm.example.helper.AccountHelper;
import cucumber.api.Transform;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

@ContextConfiguration(classes = {TestConfiguration.class})
public class CashSlotSteps {

	private AccountHelper helper;

	@Resource
	public void setHelper(AccountHelper helper) {
		this.helper = helper;
	}

	@Then("^\\$(\\d+\\.\\d+) should be dispensed$")
	public void $_should_be_dispensed(@Transform(AmountConverter.class) Amount amount) throws Throwable {
		Assert.assertEquals("Incorrect amount dispensed", amount, helper.getCashSlot().getContents());
	}

}
