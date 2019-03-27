package StepsDefinition;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Assert;
import com.yaman.test.BaseTeste;
import com.yaman.webdriver.SeleniumDriverFactory;
import Pages.NovoUsuario;
import Pages.CadastroConta;
import Pages.HostPage;
import Pages.Login;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastroSteps extends BaseTeste {

	NovoUsuario novoUsuario;
	Login login;
	CadastroConta cadastroConta;
	String nome;
	String email;
	String senha;
	String resultdoEsperado;
	private Scenario scenario;

	@Before
	public void setUp(Scenario scenario) throws SQLException, Throwable {
		this.scenario = scenario;
		Thread.sleep(1000);
	}
	
	@After
	public void sair() throws Throwable {
		tearDown();

	}

	@Dado("^que eu esteja no site do SrBarriga na aba Login$")
	public void que_eu_esteja_no_site_do_SrBarriga() throws Throwable {

		HostPage hostPage = new HostPage(SeleniumDriverFactory.getDriver());
		login = hostPage.loadHomeLogin();
		

	}

	@Quando("^inserir um  e-mail e senha e clicar em entrar$")
	public void inserir_um_e_mail_e_senha_e_clicar_em_entrar(DataTable table) throws Throwable {

		nome = table.raw().get(1).get(0).toString();
		email = table.raw().get(1).get(1).toString();
		senha = table.raw().get(1).get(2).toString();

		login.EfetuarLogin(email, senha);
		

	}

	@Entao("^deve apresentar a mensagem de bem vindo conforme esperado$")
	public void deve_apresentar_a_mensagem_de_bem_vindo_conforme_esperado() throws Throwable {

		scenario.embed(getscreenshot(), "image/png");
		Assert.assertEquals("Bemvindo," + nome.replace(" ", "") + "!", login.getMsgSucess().replace(" ", ""));

	}

	@Dado("^que eu esteja no site do SrBarriga na aba Novo Usuario$")
	public void que_eu_esteja_no_site_do_SrBarriga_aba_novo_Usuario() throws Throwable {

		HostPage hostPage = new HostPage(SeleniumDriverFactory.getDriver());
		novoUsuario = hostPage.loadHomeCadastro();

	}

	@Quando("^inserir um nome e-mail e senha e realizar o cadastro$")
	public void inserir_um_nome_e_mail_e_senha_e_realizar_o_cadastro(DataTable table) throws Throwable {
		nome = table.raw().get(1).get(0).toString();
		email = table.raw().get(1).get(1).toString();
		senha = table.raw().get(1).get(2).toString();
		resultdoEsperado = table.raw().get(1).get(3).toString();
		novoUsuario.CadastrarUsuario(nome, email, senha);
		

	}

	@Então("^deve apresentar a mensagem conforme esperado$")
	public void o_tipo_de_pessoa_deve_ser_conforme_esperado() throws Throwable {

		scenario.embed(getscreenshot(), "image/png");
		if (resultdoEsperado.replace(" ", "").substring(18).equals("sucesso")) {
			assertEquals("Mensagem diferente da esperada.", resultdoEsperado.replace("á", "a").replace(" ", ""),
					novoUsuario.getMsgSucess().replace("á", "a").replace(" ", ""));
		} else {
			assertEquals("Mensagem diferente da esperada.", resultdoEsperado.replace(" ", ""),
					novoUsuario.getMsgFail().replace("á", "a").replace("ç", "c").replace(" ", ""));
		}

	}

	@Quando("^clicar no menu Contas e Adicionar$")
	public void clicar_no_menu_Contas_e_Adicionar() throws Throwable {

		cadastroConta = login.acessarAdicionarConta();

	}

	@Quando("^inserir um valor no nome e clicar em Salvar$")
	public void inserir_um_valor_no_nome_e_clicar_em_Salvar() throws Throwable {

		cadastroConta.adicionarConta(nome);

	}

	@Entao("^deve apresentar a mensagem de sucesso$")
	public void deve_apresentar_a_mensagem_de_sucesso() throws Throwable {

		scenario.embed(getscreenshot(), "image/png");
		Assert.assertEquals("Contaadicionadacomsucesso!", cadastroConta.getMsgSucess().replace(" ", ""));

	}

}
