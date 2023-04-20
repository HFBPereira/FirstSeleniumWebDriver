import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DesafioE {
    private static final String URL = "https://rachacuca.com.br/logica/problemas/show-de-talentos/";
    private static WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void setupEach() {
        driver.get(URL);
    }

    @AfterAll
    public static void setdownEach() {
        driver.quit();
    }

    @Test
    public void testLocatorID(){
            WebElement coluna1Camisa = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/div[2]/ul/li[1]/select"));
            Select select = new Select(coluna1Camisa);

            select.selectByVisibleText("amarela");
    }
}
