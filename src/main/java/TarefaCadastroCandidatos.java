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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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


//        WebElement cadastro = driver.findElement(By.id("table-cadastros-body"));

//        WebElement cadastro = driver.findElement(By.xpath("/html/body/div[2]/table"));
//        List<HashMap<String, WebElement>> userTable = new ArrayList<HashMap<String, WebElement>>();
//        List<WebElement> rowElements = cadastro.findElements(By.xpath("/html/body/div[2]/table/thead/tr"));
//
//        List<String> columnNames = new ArrayList<String>();
//        List<WebElement> headerElements = rowElements.get(0).findElements(By.xpath("/html/body/div[2]/table/thead/tr/th[1]"));
//        for (WebElement headerElement: headerElements) {
//            columnNames.add(headerElement.getText());
//        }
//
//        for (WebElement rowElement: rowElements) {
//            HashMap<String, WebElement> row = new HashMap<String, WebElement>();
//            int columnIndex = 0;
//            List<WebElement> cellElements = rowElement.findElements(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[1]"));
//            for (WebElement cellElement: cellElements) {
//                row.put(columnNames.get(columnIndex), cellElement);
//                columnIndex++;
//            }
//            userTable.add(row);
//        }

//        List<String> cadastroEfetivo = cadastro.get().stream().map(WebElement::getText).collect(Collectors.toList());
//        List<String> cadastroEsperado = Arrays.asList("João","Maria","masculino","Backend, Testes","Backend");
//        Assertions.assertArrayEquals(cadastroEfetivo.toArray(), cadastroEsperado.toArray());
    }
}
