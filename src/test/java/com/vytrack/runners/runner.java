package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/default-cucumber-reports",
				"json:target/cucumber.json"},
		features = "src/test/java/resources/com/vytrack/features",
		glue = "com.vytrack.step_defenition",
		tags = "@wip",
		dryRun = false
)
public class runner {
}
