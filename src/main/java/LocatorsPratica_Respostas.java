import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LocatorsPratica_Respostas {

    private static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/praticando_locators_selenium/";

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    public void testLocatorID() {
        WebElement element = driver.findElement(By.id("locator-id"));
        assertEquals("Achei com ID", element.getText());
    }

    @Test
    public void testLocatorClassName() {
        WebElement element = driver.findElement(By.className("locator-class-name"));
        assertEquals("Achei com Class Name", element.getText());
    }

    @Test
    public void testLocatorName() {
        WebElement element = driver.findElement(By.name("locator-name"));
        assertEquals("Achei com Name", element.getText());
    }

    @Test
    public void testLocatorCSSSelector() {
//        WebElement element = driver.findElement(By.cssSelector(".css-selector-locator"));
        WebElement element = driver.findElement(By.cssSelector("#css-selector"));
        assertEquals("Achei com CSS Selector", element.getText());
    }

    @Test
    public void testLocatorLinkText() {
        WebElement element = driver.findElement(By.linkText("Achei com o link text"));
        assertEquals("https://www.google.com/", element.getAttribute("href"));
    }

    @Test
    public void testLocatorPartialLinkText() {
        WebElement element = driver.findElement(By.partialLinkText("Achei com o partial"));
        assertEquals("https://github.com/", element.getAttribute("href"));
    }

    @Test
    public void testLocatorTagName() {
        WebElement element = driver.findElement(By.tagName("details"));
        assertEquals("Achei com Tag Name", element.getText());
    }

    @Test
    public void testLocatorXPATH() {
//        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[8]/div/div[2]/p"));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"locator-xpath\"]"));
        assertEquals("Achei com o XPATH", element.getText());
    }

}