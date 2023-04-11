import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PrimeiraAutomacao {

    @Test
    public void testGoogle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        Assertions.assertEquals("Google", driver.getTitle());
        Assertions.assertEquals("https://www.google.com/", driver.getCurrentUrl());
        driver.manage().window().setPosition(new Point(50,50));

        driver.quit();
    }

    @Test
    public void testGooglePSF(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        Assertions.assertEquals("Google", driver.getTitle());
        Assertions.assertEquals("https://www.google.com/", driver.getCurrentUrl());
        driver.manage().window().setPosition(new Point(50,50));

        driver.quit();
    }

    @Test
    public void testEdge(){
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.com/");

        Assertions.assertEquals("Google", driver.getTitle());
        Assertions.assertEquals("https://www.google.com/", driver.getCurrentUrl());

        driver.quit();
    }

//    @Test
//    public void testOpera(){
//        WebDriverManager.operadriver().setup();
//        WebDriver driver = new OperaDriverManager();
//
//        driver.get("https://www.google.com/");
//
//        Assertions.assertEquals("Google", driver.getTitle());
//        Assertions.assertEquals("https://www.google.com/", driver.getCurrentUrl());
//
//        driver.quit();
//    }
}
