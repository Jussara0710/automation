package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emailCreateField = By.id("email_create");
    private By submitCreateButton = By.cssSelector("#SubmitCreate > span");
    private By pageSubheading = By.cssSelector(".page-subheading");
    private By errorMessage = By.cssSelector("ol > li");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmailAndSubmit(String email) {
        WebElement emailField = driver.findElement(emailCreateField);
        emailField.clear();
        emailField.sendKeys(email);
        driver.findElement(submitCreateButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getErrorMessage() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElement.getText();
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageSubheading));
    }
}
