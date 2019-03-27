# language: pt
Funcionalidade: Testar aplicacao Web 
  Para garantir que nosso site nos proporciona qualidade, eficiencia e performance
  Enquanto execucao dos testes
  Eu gostaria que os resultados sejam conforme o esperado

@CadastroUsuario
  Esquema do Cenario: Cadastro de Usuario
    Dado que eu esteja no site do SrBarriga na aba Novo Usuario
    Quando inserir um nome e-mail e senha e realizar o cadastro
	| Nome   | email   | senha   |resultadoEsperado			   |
	| <nome> | <email> | <senha> |<resultadoEsperado>		   |
	Entao deve apresentar a mensagem conforme esperado
	
	Exemplos: 
	| nome         | email              | senha  |resultadoEsperado			    |
	|Luan Goncalves| provaLuan@yaman.com|12345678|Usuario inserido com sucesso  | 
	|Luan Goncalves| teste02@yamanl.com |12345678|Endereco de email ja utilizado| 