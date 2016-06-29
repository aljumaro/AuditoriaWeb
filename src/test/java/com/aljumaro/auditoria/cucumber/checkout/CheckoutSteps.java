package com.aljumaro.auditoria.cucumber.checkout;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutSteps {

	Checkout chk = new Checkout();
	Map<String, Integer> prices = new HashMap<String, Integer>();

	@Given("^the price of a \"([^\"]*)\" is (\\d+)c$")
	public void thePriceOfAIsC(String arg1, int arg2) throws Throwable {
		prices.put(arg1, arg2);
	}

	@When("^i checkout (\\d+) \"([^\"]*)\"$")
	public void iCheckout(int arg1, String arg2) throws Throwable {
		chk.add(arg1, prices.get(arg2));
	}

	@Then("^the total price should be (\\d+)c$")
	public void theTotalPriceShouldBeC(int arg1) throws Throwable {
		Assert.assertEquals(arg1, chk.getTotal());
	}
}
