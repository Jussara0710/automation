package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroPage {

    private WebDriver driver;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By senhaField = By.xpath("//input[@id='passwd' and @name='passwd' and @type='password']");
    private By submitButton = By.xpath("//button[@id='SubmitLogin']");

    public void preencherEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void preencherSenha(String senha) {
        driver.findElement(senhaField).sendKeys(senha);
    }

    public void submeterCadastro() {
        driver.findElement(submitButton).click();
    }
}
