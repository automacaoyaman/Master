#language: pt
@funcionais
Funcionalidade: Acesso a conta

Cenário: Deve validar o acesso a conta

  Esquema do Cenário: Deve validar o acesso a conta
    Dado que acesso o site "https://srbarriga.herokuapp.com"
    Quando preencho os campos "email" e "senha" cujos valores sao "<email>" e "<senha>"
    E clico no botao "Entrar"
    Entao valido a mensagem de texto “Bem vindo, "<usuario>"!"
    E clico no botao "Sair"

    Exemplos: 
  	usuario   | email                              | senha
  	123       | clarkewerton@hotmail.com           | 12345678
  

