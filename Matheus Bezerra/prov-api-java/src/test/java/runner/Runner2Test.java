package runner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		tags = {"@api"}, 
		glue = "steps", 
		monochrome = true,
		dryRun=false)

public class Runner2Test {

}