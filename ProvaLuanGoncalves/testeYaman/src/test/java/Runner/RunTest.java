package Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.yaman.test.BaseTeste;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", 
		"html:target/cucumber-html-report",
"json:target/cucumber.json"},
       features = "features",
       glue = {"StepsDefinition"},
       tags = {"@CadastroUsuario, @AcessarConta, @AdicionaConta"},
    		   dryRun = false)

public class RunTest  extends BaseTeste{
	
	@AfterClass
	public static void afterClass() throws Exception {
		
		BaseTeste sair = new BaseTeste();
    	sair.tearDown();
	}
}
