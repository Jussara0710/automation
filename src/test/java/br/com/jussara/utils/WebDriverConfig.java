package br.com.jussara.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class WebDriverConfig {

    // Método para criar o WebDriver com opções padrão e tamanho de janela configurado
    public static WebDriver criarDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080)); // Tamanho fixo da janela
        return driver;
    }

    // Método para criar WebDriver com tempo de espera configurado
    public static WebDriverWait criarWait(WebDriver driver, int tempoEmSegundos) {
        return new WebDriverWait(driver, Duration.ofSeconds(tempoEmSegundos)); // Selenium 4
    }

    // Método para criar WebDriver com opções personalizadas (como o modo anônimo)
    public static WebDriver criarDriverComOpcoes() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");  // Janela maximizada
        options.addArguments("--disable-notifications");  // Desabilita notificações

        return new ChromeDriver(options);
    }

    // Método para inicializar o WebDriver e acessar a URL inicial do teste
    public static WebDriver inicializarDriverComUrl(String url) {
        WebDriver driver = criarDriver();
        driver.get(url);  // Acessa a URL inicial do teste
        return driver;
    }
}
