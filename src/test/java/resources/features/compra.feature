Feature: Testes de compra no site AutomationPractice

  Como um usuário,
  Eu quero realizar compras no site AutomationPractice,
  Para garantir que a funcionalidade de compra e envio de produtos para amigos e redes sociais esteja funcionando corretamente.

  Scenario: Envio de imagem de roupa com sucesso
  Dado que eu estou logado com o email "tereza-barbosa93@rocketmail.com" e senha "1234567"
  E que eu navego para a categoria "Women"
  Quando eu seleciono o produto "Faded Short Sleeve T-shirts"
  E eu escolho a cor "Blue"
  E eu envio o produto para meu amigo "Pablo" com o email "Pablo@example.com"
  Então eu devo ver a confirmação de envio do produto para meu amigo

  Scenario: Envio para o Facebook sem estar logado
  Dado que eu estou logado com o email "jussara.sousa0710@gmail.com" e senha "123456"
  E que eu navego para a categoria "Women"
  Quando eu seleciono o produto "Blouse"
  E eu compartilho o produto no Facebook
  Então eu devo ser redirecionado para a página do Facebook
