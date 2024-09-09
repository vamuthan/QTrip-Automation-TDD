package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeTest
    public void setup() {
        driver =  new ChromeDriver();
        driver.get("https://qtripdynamic-qa-frontend.vercel.app");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
