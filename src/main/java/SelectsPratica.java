import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectsPratica {
    private static final String URL = "https://igorsmasc.github.io/praticando_selects_radio_checkbox/";
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
    public void testSelectIndividual() {
        WebElement selectWebElement = driver.findElement(By.id(""));
        Select select = new Select(selectWebElement);

        select.selectByValue("Lanche");
        select.selectByIndex(2);
        select.selectByVisibleText("Almoço e Janta");

        Assertions.assertEquals("", select.getFirstSelectedOption().getText());
        Assertions.assertTrue(select.getFirstSelectedOption().isSelected());
    }

    @Test
    public void testSelectMultiplosValidaTamanho() {
        WebElement selectMultWebElement = driver.findElement(By.id(""));
        Select select = new Select(selectMultWebElement);

        Assertions.assertEquals(7, select.getOptions().size());
    }

    @Test
    public void testSelectMultiplosValidaOpcoes() {
        WebElement selectMultWebElement = driver.findElement(By.id("ingredientes"));
        Select select = new Select(selectMultWebElement);

        System.out.println(select.getOptions().stream().map(e -> e.getText()).collect(Collectors.toList()));

        List<String> ListaRecebida = (select.getOptions().stream().map(e -> e.getText()).collect(Collectors.toList()));
        List<String> ListaEsperada = Arrays.asList("Ovos", "Chocolate", "Frango", "Manteiga", "Leite", "Farinha", "Açucar");
    }
}
