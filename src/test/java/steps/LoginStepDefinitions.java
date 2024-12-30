package steps;

import br.com.jussara.utils.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginStepDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = WebDriverConfig.criarDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Dado("que o usuário esteja na página de login")
    public void dadoQueOUsuarioEstejaNaPaginaDeLogin() {
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    @Quando("o usuário inserir seu email {string} e submeter")
    public void quandoOUsuarioInserirSeuEmailESubmeter(String email) {
        loginPage.enterEmailAndSubmit(email);
        loginPage.waitForPageToLoad();
    }

    @Então("a página deve exibir o título {string}")
    public void entaoAPaginaDeveExibirOTitulo(String expectedTitle) {
        assertThat("O título da página está incorreto!", loginPage.getPageTitle(), is(expectedTitle));
    }

    @Então("a página deve exibir a mensagem de erro {string}")
    public void entaoAPaginaDeveExibirAMensagemDeErro(String expectedErrorMessage) {
        String errorText = loginPage.getErrorMessage();
        assertThat("A mensagem de erro está incorreta!", errorText, is(expectedErrorMessage));
    }
}
