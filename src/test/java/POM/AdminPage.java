package POM;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item']")
    private WebElement adminButton;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void navigateToAdmin() throws InterruptedException {
    	wait.until(ExpectedConditions.elementToBeClickable(adminButton)).click();
    }
}

