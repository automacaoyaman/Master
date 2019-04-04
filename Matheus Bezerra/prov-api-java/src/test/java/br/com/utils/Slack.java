package br.com.utils;

import java.net.MalformedURLException;
import java.text.NumberFormat;

import com.gargoylesoftware.htmlunit.javascript.host.fetch.Response;

public class Slack {

	public static final String CST_CHANNEL = "#general";
	
	public static void MontarMensagem(String time, int passed, int failed, int notRun, int develop)
	{
		String farolProjeto;
		String icon;
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumIntegerDigits(1);
		
		double total = passed+failed+notRun;
		double percent_passed = passed/total;
		double percent_failed = failed/total;
		double percent_notRun = notRun/total;
		
		System.out.println(total + " " + percent_passed + " " + percent_failed + " " + percent_notRun);
		
		if (failed > 0)
			icon = "https://cdn4.iconfinder.com/data/icons/security-overcolor/512/bug-512.png";
		else 
			icon = "https://help.quavermusic.com/wp-content/uploads/sites/2/2017/04/pass-icon.png";

		if (percent_passed > 0.95)
			farolProjeto = "#22ff22";
		else if (percent_passed > 0.75)
			farolProjeto = "#ffff22";
		else
			farolProjeto = "#ff2222";
		
		System.out.println("TEMPO " +  System.currentTimeMillis()/1000);
		
		EnviarMensagem(" {\"text\": \"**Regressão Automática**\",\"attachments\": "
				+ "[{\"fallback\": \"Status report de execução de testes\","
		              +	"\"color\": \"" + farolProjeto + "\","
	    			  + "\"author_name\": \"[Equipe de Testes]\","
	    			  + "\"author_icon\": \"" + icon + "\","
	    			  +	"\"title\": \"Resumo de Execução\","
	    			  + "\"title_link\": \LINK SLACK\"," 
	    			  + "\"fields\": ["
	    			  	+ "{\"title\": \"Executados com Sucesso\",\"value\": \"" + percent.format(percent_passed) + "\"},"
			  			+ "{\"title\": \"Executados com Falha\",\"value\": \"" + percent.format(percent_failed) + "\"},"
	  					+ "{\"title\": \"Não executados\"," + "\"value\": \"" + percent.format(percent_notRun) + "\"}]"
					+ "},"
					+ "{\"fallback\": \"Status de Construção\"," 
					+ "\"color\": \"#889988\","
					+ "\"fields\":["
						+ "{\"title\": \"Construídos\",\"value\": \"" + (int)total + "\"},"
						+ "{\"title\": \"Em construção \",\"value\": \"" + develop + "\"}]"
					+ ",\"ts\": \"" + System.currentTimeMillis()/1000 + "\"}]}",
				CST_CHANNEL);
		
	}
	
	public static void main(String[] args) throws MalformedURLException
	{
		MontarMensagem("teste", 120, 10, 1,1);
	}
	
	public static void EnviarMensagem(String str_message, String channel)
	{
		//.post("https://hooks.slack.com/services/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")
		
		String request = "";
		switch (channel)
		{
		case "#general":
			request = "https://hooks.slack.com/services/";
		break;
		case "#random":
			request = "https://hooks.slack.com/services/";
		break;
		}
		
		Response response = given()
							.contentType("application/json")
							.when()
							.body(str_message)
							.post(request)
							.then()
							.extract()
							.response();
		System.out.println(response.print());
	}

}
