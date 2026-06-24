package selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity18 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://training-support.net/webelements/alerts");
        System.out.println("Page title: " + driver.getTitle());
        
        driver.findElement(By.id("simple")).click();
        
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert message : "+alert.getText());
        alert.dismiss();
        String res = driver.findElement(By.id("result")).getText();
        System.out.println("Result : "+res);
        
        driver.quit();
        
    }
}