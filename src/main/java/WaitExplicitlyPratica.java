import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitExplicitlyPratica {

    private static final String URL = "https://igorsmasc.github.io/praticando_waits/";
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
    public void botaoEscondidoTest() {
        WebElement elemento = driver.findElement(By.id("botao-escondido"));
        wait.until(ExpectedConditions.visibilityOf(elemento));

        driver.findElement(By.id("botao-escondido")).click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Você clicou no botão escondido!", alerta.getText());
    }

    @Test
    public void botaoAlertaTest() {
        driver.findElement(By.id("botao-alerta")).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Alerta após 3 segundos!", alerta.getText());
    }

    @Test
    public void botaoTituloTest() {
        WebElement tituloTroca = driver.findElement(By.id("titulo"));

        Assertions.assertEquals("Título da Página", tituloTroca.getText());

        driver.findElement(By.id("botao-titulo")).click();
        wait.until(ExpectedConditions.textToBe(By.id("titulo"),"Novo Título da Página"));

        Assertions.assertEquals("Novo Título da Página", tituloTroca.getText());
    }

    @Test
    public void botaoParagrafoTest() {
        driver.findElement(By.id("botao-paragrafo")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("p")));

        WebElement tituloTroca = driver.findElement(By.xpath("/html/body/p"));

        Assertions.assertEquals("Este é um novo parágrafo adicionado após 3 segundos.", tituloTroca.getText());
    }

    @Test
    public void botaoNovoTest() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("botao-novo")));
        driver.findElement(By.id("botao-novo")).click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Botão clicado!", alerta.getText());
    }
}
