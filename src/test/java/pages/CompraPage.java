package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CompraPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By campoEmail = By.id("email");
    private By campoSenha = By.id("passwd");
    private By categoriaMulheres = By.xpath("//a[@title='Women' and @class='sf-with-ul']");
    private By imagemProduto = By.xpath("//img[@alt='Faded Short Sleeve T-shirts']");
    private By corAzul = By.cssSelector("a#color_14[title='Blue']");
    private By botaoEnviarParaAmigo = By.id("send_friend_button");
    private By campoNomeAmigo = By.id("friend_name");
    private By campoEmailAmigo = By.id("friend_email");
    private By botaoEnviar = By.xpath("//span[text()='Send']");
    private By botaoOK = By.xpath("//input[@class='button' and @value='OK']");
    private By botaoFacebook = By.xpath("//button[@data-type='facebook' and @class='btn btn-default btn-facebook social-sharing']");

    public CompraPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement esperarElementoClicavel(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public CompraPage preencherEmail(String email) {
        esperarElementoClicavel(campoEmail).sendKeys(email);
        return this;
    }

    public CompraPage preencherSenha(String senha) {
        esperarElementoClicavel(campoSenha).sendKeys(senha);
        return this;
    }

    public CompraPage fazerLogin(String email, String senha) {
        preencherEmail(email);
        preencherSenha(senha);
        esperarElementoClicavel(campoSenha).submit();
        return this;
    }

    public CompraPage acessarCategoriaMulheres() {
        esperarElementoClicavel(categoriaMulheres).click();
        return this;
    }

    public CompraPage selecionarProduto() {
        esperarElementoClicavel(imagemProduto).click();
        return this;
    }

    public CompraPage selecionarCorAzul() {
        esperarElementoClicavel(corAzul).click();
        return this;
    }

    public CompraPage enviarParaAmigo(String nomeAmigo, String emailAmigo) {
        esperarElementoClicavel(botaoEnviarParaAmigo).click();
        esperarElementoClicavel(campoNomeAmigo).sendKeys(nomeAmigo);
        esperarElementoClicavel(campoEmailAmigo).sendKeys(emailAmigo);
        esperarElementoClicavel(botaoEnviar).click();
        return this;
    }

    public CompraPage confirmarEnvio() {
        esperarElementoClicavel(botaoOK).click();
        return this;
    }

    public CompraPage compartilharNoFacebook() {
        esperarElementoClicavel(botaoFacebook).click();
        return this;
    }

    public void selecionarCor(String cor) {
    }
}
