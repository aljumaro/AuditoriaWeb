package com.aljumaro.auditoria;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/" }, glue = "com.aljumaro.auditoria.test")
public class RunCukesTest {

}