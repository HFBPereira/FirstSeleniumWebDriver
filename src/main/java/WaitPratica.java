import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WaitPratica {
    private static final String URL = "https://igorsmasc.github.io/praticando_waits/";
    private static WebDriver driver;

    @BeforeEach
    public void setUpEach() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.get(URL);
    }

    @AfterEach
    public void setDownEach() {
        driver.quit();
    }

    //sem Wait
    @Test
    public void botaoEscondidoTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("botao-escondido")).click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Você clicou no botão escondido!", alerta.getText());
    }

    @Test
    public void botaoAlertaTest() throws InterruptedException {
        driver.findElement(By.id("botao-alerta")).click();
        Thread.sleep(5000);

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Alerta após 3 segundos!", alerta.getText());
    }

    @Test
    public void botaoTituloTest() throws InterruptedException {
        driver.findElement(By.id("botao-titulo")).click();
        Thread.sleep(5000);

        WebElement tituloTroca = driver.findElement(By.id("titulo"));

        Assertions.assertEquals("Novo Título da Página", tituloTroca.getText());
    }

    @Test
    public void botaoParagrafoTest() throws InterruptedException {
        driver.findElement(By.id("botao-paragrafo")).click();
        Thread.sleep(5000);

        WebElement tituloTroca = driver.findElement(By.xpath("/html/body/p"));

        Assertions.assertEquals("Este é um novo parágrafo adicionado após 3 segundos.", tituloTroca.getText());
    }

    @Test
    public void botaoNovoTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("botao-novo")).click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Botão clicado!", alerta.getText());
    }
}
