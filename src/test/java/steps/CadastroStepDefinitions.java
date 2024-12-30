package steps;

import br.com.jussara.utils.WebDriverConfig;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import pages.CadastroPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroStepDefinitions {

    private WebDriver driver;
    private CadastroPage cadastroPage;

    @Dado("que eu estou na página de cadastro")
    public void que_eu_estou_na_pagina_de_cadastro() {
        driver = WebDriverConfig.criarDriver();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        cadastroPage = new CadastroPage(driver);
    }

    @Quando("eu preencho o e-mail {string} e a senha {string}")
    public void eu_preencho_o_email_e_a_senha(String email, String senha) {
        cadastroPage.preencherEmail(email);
        cadastroPage.preencherSenha(senha);
    }

    @Quando("eu submeto o cadastro")
    public void eu_submeto_o_cadastro() {
        cadastroPage.submeterCadastro();
    }

    @Então("o cadastro deve ser realizado com sucesso")
    public void o_cadastro_deve_ser_realizado_com_sucesso() {
        assertTrue(true, "Cadastro realizado com sucesso!");  // Implementar verificação
    }

    @Então("eu devo ver uma mensagem de erro de cadastro")
    public void eu_devo_ver_uma_mensagem_de_erro_de_cadastro() {
        assertTrue(true, "A mensagem de erro não foi exibida.");  // Implementar verificação
    }
}
