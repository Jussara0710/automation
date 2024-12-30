Feature: Login

  Como um usuário
  Eu quero fazer login no site
  Para poder acessar minha conta.

  Scenario: Login com sucesso
  Dado que o usuário esteja na página de login
  Quando o usuário inserir seu email "jussara.sousa0710@gmail.com" e submeter
  Então a página deve exibir o título "Login - My Shop"

  Scenario: Login com email inválido
  Dado que o usuário esteja na página de login
  Quando o usuário inserir um email inválido "111111" e submeter
  Então a página deve exibir a mensagem de erro "Invalid email address."
