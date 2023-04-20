import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WaitimplicitlyPratica {

    private static final String URL = "https://igorsmasc.github.io/praticando_waits/";
    private static WebDriver driver;

    @BeforeEach
    public void setUpEach() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void setDownEach() {
        // driver.close(); Fecha apenas 1 aba / 1 janela
        driver.quit(); // Fechar tudo
    }

    @Test
    public void botaoEscondidoTest() {
        WebElement elemento = driver.findElement(By.id("botao-escondido"));
        elemento.click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Você clicou no botão escondido!", alerta.getText());
    }

    @Test
    public void botaoAlertaTest() {
        driver.findElement(By.id("botao-alerta")).click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Alerta após 3 segundos!", alerta.getText());
    }

    @Test
    public void botaoTituloTest() {
        WebElement tituloTroca = driver.findElement(By.id("titulo"));
        Assertions.assertEquals("Título da Página", tituloTroca.getText());

        driver.findElement(By.id("botao-titulo")).click();

        Assertions.assertEquals("Novo Título da Página", tituloTroca.getText());
    }

    @Test
    public void botaoParagrafoTest() {
        driver.findElement(By.id("botao-paragrafo")).click();

        WebElement tituloTroca = driver.findElement(By.xpath("/html/body/p"));

        Assertions.assertEquals("Este é um novo parágrafo adicionado após 3 segundos.", tituloTroca.getText());
    }

    @Test
    public void botaoNovoTest() {
        driver.findElement(By.id("botao-novo")).click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Botão clicado!", alerta.getText());
    }
}
