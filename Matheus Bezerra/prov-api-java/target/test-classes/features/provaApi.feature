#language: pt
Funcionalidade: Prova Yaman API

#Teste usando os dados de uma API
@api
Esquema do Cenário: Dados do correio
    Dado que foi realizada a conexao "<url>"
    Quando receber os valores da API
    Então devo comparar se o retorno dos valores da API estao em conformidade com a "<rua>", "<cidade>", "<cep>" e "<estado>"
    Exemplos:
    | url                                       |rua                  | cidade    | cep     | estado|
    | http://api.postmon.com.br/v1/cep/06454000 | Alameda Rio Negro   | Barueri   | 06454000| SP    |
