# language: pt
Funcionalidade: Testar aplicacao Web 
	Para garantir que nosso site nos proporciona qualidade, eficiencia e performance
  Enquanto execucao dos testes
  Eu gostaria que os resultados sejam conforme o esperado

@AcessarConta
  Esquema do Cenario: Acesso de Usuario
    Dado que eu esteja no site do SrBarriga na aba Login 
    Quando inserir um  e-mail e senha e clicar em entrar
	| nome   | email   | senha   |
	| <nome> | <email> | <senha> |
	Entao deve apresentar a mensagem de bem vindo conforme esperado
	
	Exemplos: 
	| nome         | email            | senha  |
	|Luan Goncalves| teste1@yamanl.com|12345678|