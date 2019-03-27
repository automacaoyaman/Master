# language: pt
Funcionalidade: Testar aplicacao Web 
	Para garantir que nosso site nos proporciona qualidade, eficiencia e performance
  Enquanto execucao dos testes
  Eu gostaria que os resultados sejam conforme o esperado

	@AdicionaConta 
	Esquema do Cenario: Adicionar Conta
	Dado que eu esteja no site do SrBarriga na aba Login 
	Quando inserir um  e-mail e senha e clicar em entrar 
	| nome   | email   | senha   |
	| <nome> | <email> | <senha> |
	E clicar no menu Contas e Adicionar 
	E inserir um valor no nome e clicar em Salvar 
	Entao deve apresentar a mensagem de sucesso 
	
	Exemplos: 
	| nome            | email            | senha  |
	|Conta Yaman Luan | teste9@yamanl.com|12345678|