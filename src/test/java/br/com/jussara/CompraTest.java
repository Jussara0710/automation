package br.com.jussara;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class ComprasTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        driver.manage().window().setSize(new Dimension(1200, 800));
    }

    @Test
    public void enviodeImagemDeRoupaComSucesso() {
        driver.findElement(By.id("email")).sendKeys("jussara.sousa0710@gmail.com");
        WebElement senhaInput = driver.findElement(By.xpath("//input[@id='passwd' and @name='passwd' and @type='password']"));
        senhaInput.sendKeys("123456");
        senhaInput.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement womenCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Women' and @class='sf-with-ul']")));
        womenCategory.click();

        WebElement productImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']")));
        productImage.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#color_14[title='Blue']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("send_friend_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("friend_name"))).sendKeys("Pablo");
        driver.findElement(By.id("friend_email")).sendKeys("Pablo@example.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Send']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button' and @value='OK']"))).click();
    }

    @Test
    public void envioParaFacebookSemEstarLogado() {
        driver.findElement(By.id("email")).sendKeys("jussara.sousa0710@gmail.com");
        WebElement senhaInput = driver.findElement(By.xpath("//input[@id='passwd' and @name='passwd' and @type='password']"));
        senhaInput.sendKeys("123456");
        senhaInput.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement womenCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Women' and @class='sf-with-ul']")));
        womenCategory.click();

        WebElement productImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Blouse' and @title='Blouse']")));
        productImage.click();

        WebElement facebookButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-type='facebook' and @class='btn btn-default btn-facebook social-sharing']")));
        facebookButton.click();

        driver.quit();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
