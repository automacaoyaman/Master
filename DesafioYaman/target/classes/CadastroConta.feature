#language: pt
@funcionais
Funcionalidade: Cadastro de conta

Cenário: Cadastro de conta

  Esquema do Cenário: Deve cadastrar uma conta com sucesso
    Dado que acesso o site "https://srbarriga.herokuapp.com"
    Quando preencho os campos "email" e "senha" cujos valores sao "<email>" e "<senha>"
    E clico no botao "Entrar"
    Entao valido a mensagem de texto “Bem vindo, "<usuario>"!"
    E clico na opcao de menu "Contas" e, em seguida, "Adicionar"
    E na tela de Contas preencho o campo "Nome" cujo da valor da conta sera "<conta>"
    E clico no botao "Salvar"
    E valido a mensagem de texto “Conta adicionada com sucesso!"

  Exemplos: 
    usuario   | email                              | senha       | conta
  	123       | clarkewerton@hotmail.com           | 12345678    | Conta 1


