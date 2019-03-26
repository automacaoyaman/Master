#language: pt
@funcionais
Funcionalidade: Cadastro de usuario com falha

  Esquema do Cenário: Deve validar cadastrar usuario falha
    Dado que acesso o site "https://srbarriga.herokuapp.com"
    Quando clico na aba “Novo usuário” e insero um "<nome>", "<email>" e "<senha>"
    E clico no botao "Cadastrar"
    Entao valido a mensagem de texto “Endereço de e-mail já utilizado”

    Exemplos: 
      | nome             | email                              | senha
      | clark.silva      | clarkewerton@hotmail.com           | 12345678