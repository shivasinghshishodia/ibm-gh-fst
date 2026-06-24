package selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://training-support.net/webelements/tabs");
        String parentHandle = driver.getWindowHandle();
        System.out.println("Page title: " + driver.getTitle());
        
        	WebElement text = driver.findElement(By.xpath("//button[text()='Open A New Tab']"));
        	text.click();
        	
        	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        	Set<String> handles = driver.getWindowHandles();
        	System.out.println("The handle is : "+parentHandle);
        	
        	for(String handle : handles) {
        		if(handle != parentHandle) {
        			driver.switchTo().window(handle);
        		}
        	}
        	wait.until(ExpectedConditions.titleIs("New Tab!"));
        	WebElement text1 =driver.findElement(By.xpath("//h2"));
        	System.out.println("The message is : "+text1.getText());
        	driver.quit();
        	
        	
        	
    }
}
