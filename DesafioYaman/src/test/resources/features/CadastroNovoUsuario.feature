#language: pt
@funcionais
Funcionalidade: Cadastro de usuario

  Esquema do Cenário: Deve validar cadastrar usuario sucesso
  Dado que acesso o site "https://srbarriga.herokuapp.com"
    Quando clico na aba “Novo usuário” e insero um "<nome>", "<email>" e "<senha>"
    E clico no botao "Cadastrar"
    Entao valido a mensagem de texto “Usuário inserido com sucesso”

    Exemplos: 
      | nome             | email                              | senha
      | clark.silva      | clarkewerton@hotmail.com           | 12345678