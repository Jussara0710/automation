package br.com.jussara;

import br.com.jussara.utils.WebDriverConfig;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverConfig.criarDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    @Order(1)
    public void loginComSucesso() {
        loginPage.enterEmailAndSubmit("jussara.sousa0710@gmail.com");
        loginPage.waitForPageToLoad();
        assertThat(loginPage.getPageTitle(), is("Login - My Shop"));
    }

    @Test
    @Order(2)
    public void loginInvalido() {
        loginPage.enterEmailAndSubmit("111111");
        String errorText = loginPage.getErrorMessage();
        System.out.println("Mensagem de erro: " + errorText);
        assertThat(errorText, is("Invalid email address."));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
