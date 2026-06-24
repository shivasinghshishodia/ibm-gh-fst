package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity15 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/dynamic-attributes");
        System.out.println("Page title: " + driver.getTitle());
        WebElement name = driver.findElement(By.xpath("//input[contains(@id, 'full-name')]"));
        WebElement email = driver.findElement(By.xpath("//input[contains(@id, 'email')]"));
        WebElement date = driver.findElement(By.xpath("//input[contains(@data-testid, 'event-date')]"));
        WebElement add = driver.findElement(By.xpath("//textarea[contains(@id, 'additional-details')]"));
        
        name.sendKeys("Shiva singh");
        email.sendKeys("shiva@ibm.com");
        date.sendKeys("2004-02-18");
        add.sendKeys("Hi there");
        
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
        String res = driver.findElement(By.xpath("//h3[contains(@id, action-confirmation)]")).getText();
        System.out.println("Message: "+res);
        
        driver.quit();
        
    }
}
