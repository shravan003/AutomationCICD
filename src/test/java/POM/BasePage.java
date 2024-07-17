package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    protected WebDriver driver;

    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\User\\eclipse-workspace\\Demo\\driver\\chromedriver.exe");

        // Initialize the Chrome driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait of 10 seconds
        driver.manage().window().maximize();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
