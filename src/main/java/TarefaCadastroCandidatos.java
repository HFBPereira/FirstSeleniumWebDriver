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
import org.openqa.selenium.support.ui.Select;

public class TarefaCadastroCandidatos {
    private static final String URL = "https://igorsmasc.github.io/fomulario_cadastro_selenium/";
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
        Assertions.assertEquals("Cadastro de candidatos", driver.getTitle());
    }

    @Test
    public void cadastroTest() {
        driver.findElement(By.id("nome")).sendKeys("João");
        driver.findElement(By.id("sobrenome")).sendKeys("Maria");
        driver.findElement(By.id("masculino")).click();
        driver.findElement(By.id("java")).click();
        driver.findElement(By.id("selenium")).click();

        WebElement areasInteresse = driver.findElement(By.id("area-interesse"));
        Select interesses = new Select(areasInteresse);
        interesses.selectByVisibleText("Backend");
        interesses.selectByVisibleText("Testes");

        WebElement areaPrincipal = driver.findElement(By.id("motivacao"));
        Select motivacao = new Select(areaPrincipal);
        motivacao.selectByIndex(2);

        driver.findElement(By.id("porque")).sendKeys("Porque acredito ter capacidade de auxiliar no crescimento da empresa.");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assertions.assertEquals("João", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[1]")).getAttribute("innerHTML"));
        Assertions.assertEquals("Maria", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[2]")).getAttribute("innerHTML"));
        Assertions.assertEquals("masculino", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[3]")).getAttribute("innerHTML"));
        Assertions.assertEquals("Backend, Testes", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[4]")).getAttribute("innerHTML"));
        Assertions.assertEquals("Backend", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[5]")).getAttribute("innerHTML"));
    }
}
