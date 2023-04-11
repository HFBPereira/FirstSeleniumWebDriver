import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPratica {

    private static final String URL = "https://igorsmasc.github.io/praticando_locators_selenium/";
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterAll
    public static void afterEach(){
        driver.quit();
    }

    @Test
    public void testTitulo(){
        Assertions.assertEquals("Praticando Locators", driver.getTitle());
    }

    @Test
    public void locatorByID(){
        WebElement elemento = driver.findElement(By.id("locator-id"));
        Assertions.assertEquals("Achei com ID", elemento.getText());
    }

    @Test
    public void locatorByClassName(){
        WebElement elemento = driver.findElement(By.className("locator-class-name"));
        Assertions.assertEquals("Achei com Class Name", elemento.getText());
    }

    @Test
    public void locatorByName(){
        WebElement elemento = driver.findElement(By.name("locator-name"));
        Assertions.assertEquals("Achei com Name", elemento.getText());
    }

    @Test
    public void locatorByCssSelector(){
        WebElement elemento = driver.findElement(By.cssSelector("#css-selector"));
//        WebElement elemento = driver.findElement(By.cssSelector(".css-selector-locator"));
//        WebElement elemento = driver.findElement(By.cssSelector(".lead.css-selector-locator"));
//        WebElement elemento = driver.findElement(By.cssSelector("p.lead.css-selector-locator"));
//        WebElement elemento = driver.findElement(By.cssSelector("div p.lead.css-selector-locator"));
        Assertions.assertEquals("Achei com CSS Selector", elemento.getText());
    }

    @Test
    public void locatorByLinkText(){
        WebElement elemento = driver.findElement(By.linkText("Achei com o link text"));
        Assertions.assertEquals("Achei com o link text", elemento.getText());
    }

    @Test
    public void locatorByPartialLinkText() {
        WebElement elemento = driver.findElement(By.partialLinkText("Achei com o partial"));
        Assertions.assertEquals("https://github.com/", elemento.getAttribute("href"));
    }

    @Test
    public void locatorByTagName(){
        WebElement elemento = driver.findElement(By.tagName("details"));
        Assertions.assertEquals("Achei com Tag Name", elemento.getText());
    }

    @Test
    public void locatorByXPATH(){
        WebElement elemento = driver.findElement(By.xpath("//*[@id=\"locator-xpath\"]"));
        Assertions.assertEquals("Achei com o XPATH", elemento.getText());
    }

}
