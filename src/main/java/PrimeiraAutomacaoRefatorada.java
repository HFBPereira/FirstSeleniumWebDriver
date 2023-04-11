import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeiraAutomacaoRefatorada {

    private static final String URL = "https://www.google.com/";

    private WebDriver driver;

    @BeforeEach
    public void beforeEach(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

    @Test
    public void testGoogle1(){
        Assertions.assertEquals("Google", driver.getTitle());
    }

    @Test
    public void testGoogle2(){
        Assertions.assertEquals(URL, driver.getCurrentUrl());
    }

    @Test
    public void testGoogle3(){
        driver.manage().window().setPosition(new Point(50,50));
    }
}
