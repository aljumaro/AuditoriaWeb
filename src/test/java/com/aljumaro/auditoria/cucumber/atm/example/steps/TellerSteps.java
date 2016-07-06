package com.aljumaro.auditoria.cucumber.atm.example.steps;

import com.aljumaro.auditoria.cucumber.TestConfiguration;
import com.aljumaro.auditoria.cucumber.atm.example.domain.Amount;
import com.aljumaro.auditoria.cucumber.atm.example.converter.AmountConverter;
import com.aljumaro.auditoria.cucumber.atm.example.helper.AccountHelper;
import cucumber.api.Transform;
import cucumber.api.java.en.When;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

@ContextConfiguration(classes = {TestConfiguration.class})
public class TellerSteps {

	private AccountHelper helper;

	@Resource
	public void setHelper(AccountHelper helper) {
		this.helper = helper;
	}

	@When("^I withdraw \\$(\\d+\\.\\d+)$")
	public void iWithdraw$(@Transform(AmountConverter.class) Amount amount) throws Throwable {
		helper.getTeller().withdrawFrom(helper.getAccount(), amount);
	}

}
