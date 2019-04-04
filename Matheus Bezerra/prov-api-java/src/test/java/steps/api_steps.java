package steps;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import pages.api_page;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * Unit test for simple App.
 */
public class api_steps {
	
	api_page apiPage = new api_page();
	
	@Dado("^que foi realizada a conexao \"([^\"]*)\"$")
	public void que_foi_realizada_a_conexao(String arg1) throws Exception {
		apiPage.acessarUrl(arg1);
		
	}

	@Quando("^receber os valores da API$")
	public void receber_os_valores_da_API() throws Exception {
		apiPage.chamadaApi();
	
	}

	@Então("^devo comparar se o retorno dos valores da API estao em conformidade com a \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\"$")
	public void devo_comparar_se_o_retorno_dos_valores_da_API_estao_em_conformidade_com_a_e(String arg1, String arg2, String arg3, String arg4) throws Exception {
		apiPage.validarRetorno(arg1, arg2, arg3, arg4);
	}

}
