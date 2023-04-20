import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TarefaCalculadora {
    private static final String URL = "https://igorsmasc.github.io/calculadora_atividade_selenium/";
    private static WebDriver driver;

    @BeforeEach
    public void setupEach() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.get(URL);
    }

    @AfterEach
    public void setdownEach() {
       driver.quit();
    }

    @Test
    public void confirmandoSite() {
        Assertions.assertEquals("Calculadora", driver.getTitle());
    }

    @Test
    public void validarSoma() {
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("six")).click();
        driver.findElement(By.id("add")).click();
        driver.findElement(By.id("four")).click();
        driver.findElement(By.id("equals")).click();

        WebElement getDisplay = driver.findElement(By.xpath("//*[@id=\"display\"]"));

        Assertions.assertEquals("10", getDisplay.getAttribute("value"));
    }

    @Test
    public void validarSubtracao() {
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("nine")).click();
        driver.findElement(By.id("subtract")).click();
        driver.findElement(By.id("four")).click();
        driver.findElement(By.id("equals")).click();

        WebElement getDisplay = driver.findElement(By.xpath("//*[@id=\"display\"]"));

        Assertions.assertEquals("5", getDisplay.getAttribute("value"));
    }

    @Test
    public void validarMultiplicacao() {
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("seven")).click();
        driver.findElement(By.id("multiply")).click();
        driver.findElement(By.id("three")).click();
        driver.findElement(By.id("equals")).click();

        WebElement getDisplay = driver.findElement(By.xpath("//*[@id=\"display\"]"));

        Assertions.assertEquals("21", getDisplay.getAttribute("value"));
    }

    public void validarDivisao() {
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("eight")).click();
        driver.findElement(By.id("divide")).click();
        driver.findElement(By.id("four")).click();
        driver.findElement(By.id("equals")).click();

        WebElement getDisplay = driver.findElement(By.xpath("//*[@id=\"display\"]"));

        Assertions.assertEquals("2", getDisplay.getAttribute("value"));
    }
}
