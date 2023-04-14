import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SRBCRPratica {
    private static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/praticando_selects_radio_checkbox/";

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

}
