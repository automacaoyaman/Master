package br.com.wcclark.runners;

import static br.com.wcclark.core.DriverFactory.getDriver;
import static br.com.wcclark.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


public class Runners {
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/resources/features/",
			glue = "br.com.wcclark.steps",
			tags = {"@funcionais"},
			plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
			monochrome = true,
			snippets = SnippetType.CAMELCASE,
			dryRun = false,
			strict = false
			)
	public static class RunnerFuncional {
		
		@BeforeClass
		public static void inicializa() {
			getDriver().get("https://srbarriga.herokuapp.com");
		}
		
		@AfterClass
		public static void finaliza() {
			killDriver();
		}


}
}
