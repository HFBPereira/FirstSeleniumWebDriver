import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonsPratica {
    private static final String URL = "https://igorsmasc.github.io/botoes_atividade_selenium/";
    private static WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1366, 768));
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
    public void clickComID() {
        WebElement captureButton = driver.findElement(By.id("button1"));
        captureButton.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 1 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    public void clickComClassName() {
        WebElement captureButton = driver.findElement(By.className("button-2"));
        captureButton.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 2 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    public void clickComName() {
        WebElement captureButton = driver.findElement(By.name("button3"));
        captureButton.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 3 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    public void clickComCSS() {
        WebElement captureButton = driver.findElement(By.cssSelector("button.button-4"));
        captureButton.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 4 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    public void clickComXPATH() {
        WebElement captureButton = driver.findElement(By.xpath("//*[@id=\"button5\"]"));
        captureButton.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 5 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    public void clickComLIVRE() {
        WebElement captureSwitch = driver.findElement(By.id("button6-switch"));
//        Assertions.assertFalse(captureSwitch.isEnabled());
        captureSwitch.click();
//        Assertions.assertTrue(captureSwitch.isEnabled());

        WebElement captureButton = driver.findElement(By.id("button6"));
        captureButton.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 6 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    public void clickComLinkText() {
        WebElement captureLink = driver.findElement(By.linkText("Link 1"));
        captureLink.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O link 1 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    public void clickComPartialLinkText() {
        WebElement captureLink = driver.findElement(By.partialLinkText("2"));
        captureLink.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O link 2 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    public void clickComLivre() {
        WebElement captureLink = driver.findElement(By.id("link3"));
        captureLink.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O link 3 foi selecionado.", alert.getText());
        alert.accept();
    }
}
