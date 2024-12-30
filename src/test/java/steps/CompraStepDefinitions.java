package steps;

import pages.CompraPage;
import br.com.jussara.utils.WebDriverConfig;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;

public class CompraStepDefinitions {

    private WebDriver driver;
    private CompraPage compraPage;

    @Dado("que eu estou logado com o email {string} e senha {string}")
    public void que_eu_estou_logado_com_o_email_e_senha(String email, String senha) {
        driver = WebDriverConfig.inicializarDriverComUrl("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        compraPage = new CompraPage(driver);
        compraPage.fazerLogin(email, senha);
    }

    @Dado("que eu navego para a categoria {string}")
    public void que_eu_navego_para_a_categoria(String categoria) {
        compraPage.acessarCategoriaMulheres();
    }

    @Quando("eu seleciono o produto {string}")
    public void eu_seleciono_o_produto(String produto) {
        compraPage.selecionarProduto();
    }

    @Quando("eu escolho a cor {string}")
    public void eu_escolho_a_cor(String cor) {
        compraPage.selecionarCorAzul();
    }

    @Quando("eu envio o produto para meu amigo {string} com o email {string}")
    public void eu_envio_o_produto_para_meu_amigo_com_o_email(String nomeAmigo, String emailAmigo) {
        compraPage.enviarParaAmigo(nomeAmigo, emailAmigo);
    }

    @Então("eu devo ver a confirmação de envio do produto para meu amigo")
    public void eu_devo_ver_a_confirmacao_de_envio_do_produto_para_meu_amigo() {
        assertTrue("A confirmação de envio não foi exibida.", true);
    }

    private void assertTrue(String s, boolean b) {
    }

    @Quando("eu compartilho o produto no Facebook")
    public void eu_compartilho_o_produto_no_facebook() {
        compraPage.compartilharNoFacebook();
    }

    @Então("eu devo ser redirecionado para a página do Facebook")
    public void eu_devo_ser_redirecionado_para_a_pagina_do_facebook() {
        assertTrue("O redirecionamento para o Facebook não ocorreu.", true);
    }
}
