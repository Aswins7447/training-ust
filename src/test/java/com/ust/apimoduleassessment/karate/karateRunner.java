package com.ust.apimoduleassessment.karate;

import org.testng.annotations.Listeners;

import com.intuit.karate.junit5.Karate;

@Listeners(com.ust.apimoduleassessment.utilities.ExtentReportsListener.class)
public class karateRunner {
	@Karate.Test
	Karate karateTest() {
		return Karate.run("karate.feature").relativeTo(getClass());
		
	}
}
