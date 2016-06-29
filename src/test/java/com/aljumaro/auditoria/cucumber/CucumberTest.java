package com.aljumaro.auditoria.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/" }, glue = "com.aljumaro.auditoria.cucumber", plugin = { "pretty",
		"json:target/cucumber.json" }, tags = "~@wip", snippets = SnippetType.CAMELCASE)
public class CucumberTest {

}