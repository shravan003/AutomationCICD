package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClaimPage {

	 private WebDriver driver;

	    public ClaimPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    
	    
	    
	    public void navigateToClaim() throws InterruptedException {
	        Thread.sleep(5000); // Use explicit waits in real scenarios
	        WebElement claimButton = driver.findElement(By.xpath("(*//a[@class='oxd-main-menu-item toggle'])[2]"));
	        claimButton.click();
	        Thread.sleep(5000);
	    }


	 //   public void navigateToBuzzPost() throws InterruptedException
	 //   {
	 //   	Thread.sleep(5000); // Use explicit waits in real scenarios
	 //       WebElement buzzButton = driver.findElement(By.xpath("*//a[@class='oxd-main-menu-item active']"));
	 //       buzzButton.click();
	 //       Thread.sleep(5000);
	        
	 //   }
	    
	  //  public void buzzPost(String txt) throws InterruptedException {
	       	        
	  //  	Thread.sleep(5000);
	  //   	WebElement txtField = driver.findElement(By.xpath("*//textarea[@class='oxd-buzz-post-input']"));
	  //      txtField.sendKeys(txt); 
	  //      Thread.sleep(5000); // Use explicit waits in real scenarios
	  //      WebElement postButton = driver.findElement(By.xpath("*//button[@class='oxd-button oxd-button--medium oxd-button--main']"));
	  //      postButton.click();
	  //      Thread.sleep(5000);
	  //  }
	
}
