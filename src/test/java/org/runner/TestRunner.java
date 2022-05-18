package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Dell\\eclipse-workspace\\"
		+ "CucumberProj\\src\\test\\resources\\Features\\LoginPage.feature", 
		glue="org.stepdef",monochrome=true,
		plugin= {"pretty","json:src\\test\\resources\\Reports//output.json"})

public class TestRunner {
	@AfterClass
	public static void genJVMReport() {
		Reporting.genReport("C:\\Users\\Dell\\eclipse-workspace\\"
				+ "CucumberProj\\src\\test\\resources\\Reports//output.json");
		
	}
	
}
