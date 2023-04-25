import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TarefaExplicitly {

    private static final String URL = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
    private static WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUpEach() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void setDownEach() {
        driver.quit();
    }

    @Test
    public void confirmandoSite() {
        Assertions.assertEquals("ExplicitlyWait Practice page in Selenium Webdriver", driver.getTitle());
    }

    @Test
    public void botaoTimer5SecondsTest() {
        driver.findElement(By.id("alert")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("I got opened after 5 secods", alerta.getText());
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void botaoMudancaTextoTest() {
        WebElement texto = driver.findElement(By.xpath("//*[@id=\"h2\"]"));
        Assertions.assertEquals("site", texto.getText());

        driver.findElement(By.id("populate-text")).click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"h2\"]"), "Selenium Webdriver"));

        Assertions.assertEquals("Selenium Webdriver", texto.getText());
    }

    @Test
    public void botaoDisplayButtonTest() {
        driver.findElement(By.id("display-other-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hidden")));

        Assertions.assertEquals("button", driver.findElement(By.id("hidden")).getTagName());
    }

    @Test
    public void botaoEnableButtonTest() {
        driver.findElement(By.id("enable-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("disable")));

        Assertions.assertEquals("button", driver.findElement(By.id("disable")).getTagName());
    }

    @Test
    public void botaoCheckboxTest() {
        WebElement check = driver.findElement(By.xpath("//*[@id=\"ch\"]"));
        Assertions.assertFalse(check.isSelected());

        driver.findElement(By.id("checkbox")).click();
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id=\"ch\"]")));

        Assertions.assertTrue(check.isSelected());
    }
}
