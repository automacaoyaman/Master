#language: pt
# encoding: utf-8
Funcionalidade: Prova Yaman Java BDD

#***************************************************Positivos*************************************************************************
@cadastro @positivo 
Esquema do Cenario: Cadastro
    Dado que foi acessado o site "<site>"
    Quando inserir o "<nome>", o "<email>" e a "<senha>" valida
    Entao devo clicar em Cadastrar e validar a mensagem "<mensagem>"
    Exemplos:
        |site                                            |nome     |email              |senha       |mensagem                     |
        |https://srbarriga.herokuapp.com/cadastro        |yamano   |prov344@yaman.com  |123456789   |Usuário inserido com sucesso|

@login @positivo 
Esquema do Cenario: Login
    Dado que foi acessado o site "<site>"
    Quando inserir o "<email>" e a "<senha>" previamente cadastradas
    E clicar em Entrar 
    E validar a mensagem "<mensagem>"
    Entao clicar em Sair e validar o logout
    Exemplos:
        |site                                          |email             |senha       |mensagem          |
        |https://srbarriga.herokuapp.com/login         |prov344@yaman.com |123456789   |Bem vindo, yamano!|

@conta @positivo 
Esquema do Cenario: Conta
    Dado que foi acessado o site "<site>"
    Quando inserir o "<email>" e a "<senha>" previamente cadastradas 
    E clicar em Entrar 
    E clicar no menu Contas e no submenu Adicionar
    E inserir um valor no campo "<nome>" e clicar em Salvar
    Entao validar a mensagem "<mensagem>" e clicar em Sair
    Exemplos:
        |site                                            |email              |senha       |nome        |mensagem                     |
        |https://srbarriga.herokuapp.com/login           |prov344@yaman.com  |123456789   |Nova Conta  |Conta adicionada com sucesso!|


 #***************************************************Negativos*************************************************************************

@cadastro @negativo 
Esquema do Cenario: Login
    Dado que foi acessado o site "<site>"
    Quando inserir o "<nome>", o "<email>" e a "<senha>" valida
    Entao devo clicar em Cadastrar e validar a mensagem de erro "<mensagem>"
    Exemplos:
        |site                                            |nome     |email            |senha       |mensagem                        |
        |https://srbarriga.herokuapp.com/cadastro        |yamano2  |prova2@yaman.com |123456789   |Endereço de email já utilizado|

@conta @negativo
Esquema do Cenario: Conta
    Dado que foi acessado o site "<site>"
    Quando inserir o "<email>" e a "<senha>" previamente cadastradas
    E clicar em Entrar 
    E clicar no menu Contas e no submenu Adicionar
    E inserir um valor no campo "<nome>" e clicar em Salvar
    Entao validar a mensagem "<mensagem>" e clicar em Sair
    Exemplos:
        |site                                      |email             |senha       |nome        |mensagem                           |
        |https://srbarriga.herokuapp.com/login     |prova2@yaman.com  |123456789   |Nova Conta  |Já existe uma conta com esse nome!|
