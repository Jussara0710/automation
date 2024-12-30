# Feature: Cadastro de Usuário

Cenário 1: Cadastro com sucesso
Dado que o usuário preenche o campo de e-mail com "jussara.sousa0710@gmail.com"
E o usuário preenche o campo de senha com "123456"
Quando o usuário submete o cadastro
Então o cadastro é realizado com sucesso

Cenário 2: Cadastro com e-mail inválido
Dado que o usuário preenche o campo de e-mail com "sousaThotmaillcom"
E o usuário preenche o campo de senha com "123456"
Quando o usuário submete o cadastro
Então uma mensagem de erro de e-mail inválido é exibida
