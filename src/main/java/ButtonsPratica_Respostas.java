import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class ButtonsPratica_Respostas {
    private static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/botoes_atividade_selenium/";

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    public void testClickButtonByID() {
        driver.get(URL);
        WebElement button1 = driver.findElement(By.id("button1"));
        button1.click();

        Alert alertButton1 = driver.switchTo().alert();

        assertEquals("O botão 1 foi selecionado.", alertButton1.getText());
        alertButton1.accept();
    }

    @Test
    public void testClickButtonByClassName() {
        driver.get(URL);
        WebElement button2 = driver.findElement(By.className("button-2"));
        button2.click();

        Alert alertButton1 = driver.switchTo().alert();

        assertEquals("O botão 2 foi selecionado.", alertButton1.getText());
        alertButton1.accept();
    }

    @Test
    public void testClickButtonByName() {
        driver.get(URL);
        WebElement button2 = driver.findElement(By.name("button3"));
        button2.click();

        Alert alertButton1 = driver.switchTo().alert();

        assertEquals("O botão 3 foi selecionado.", alertButton1.getText());
        alertButton1.accept();
    }

    @Test
    public void testClickButtonByCSS() {
        driver.get(URL);
        driver.manage().window().maximize();
//        WebElement button4 = driver.findElement(By.cssSelector("#button4"));
        WebElement button4 = driver.findElement(By.cssSelector(".button-4"));
        button4.click();

        Alert alertButton4 = driver.switchTo().alert();

        assertEquals("O botão 4 foi selecionado.", alertButton4.getText());
        alertButton4.accept();
    }

    @Test
    public void testClickButtonByXPATH() {
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement button5 = driver.findElement(By.xpath("//*[@id=\"button5\"]"));
        button5.click();

        Alert alertButton5 = driver.switchTo().alert();

        assertEquals("O botão 5 foi selecionado.", alertButton5.getText());
        alertButton5.accept();
    }

    @Test
    public void testClickButtonByLivre() {
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement switchButton = driver.findElement(By.id("button6-switch"));
        switchButton.click();

        WebElement button6 = driver.findElement(By.id("button6"));
        button6.click();

        Alert alertButton6 = driver.switchTo().alert();

        assertEquals("O botão 6 foi selecionado.", alertButton6.getText());
        alertButton6.accept();
    }

    @Test
    public void testClickButtonByLinkText() {
        driver.get(URL);
        WebElement link = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[7]/div/div[2]/a"));
        link.click();

        Alert alertLink = driver.switchTo().alert();

        assertEquals("O link 1 foi selecionado.", alertLink.getText());
        alertLink.accept();
    }

    @Test
    public void testClickButtonByPartialLinkText() {
        driver.get(URL);
        driver.manage().window().maximize();
//        WebElement link = driver.findElement(By.partialLinkText("Link 2"));
        WebElement link = driver.findElement(By.partialLinkText("2"));
        link.click();

        Alert alertLink = driver.switchTo().alert();

        assertEquals("O link 2 foi selecionado.", alertLink.getText());
        alertLink.accept();
    }
}