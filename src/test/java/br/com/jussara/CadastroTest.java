package br.com.jussara;

import br.com.jussara.utils.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.CadastroPage;

class CadastroTest {

    private WebDriver driver;
    private CadastroPage cadastroPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverConfig.criarDriver();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        cadastroPage = new CadastroPage(driver);
    }

    @Test
    public void cadastroComSucesso() {
        cadastroPage.preencherEmail("jussara.sousa0710@gmail.com");
        cadastroPage.preencherSenha("123456");
        cadastroPage.submeterCadastro();
    }

    @Test
    public void cadastroSemSucesso() throws InterruptedException {
        cadastroPage.preencherEmail("sousaThotmaillcom");
        cadastroPage.preencherSenha("1234569");
        cadastroPage.submeterCadastro();
        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Fecha o navegador após os testes
        }
    }
}
