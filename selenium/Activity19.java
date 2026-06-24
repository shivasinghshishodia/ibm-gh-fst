package selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity19 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://training-support.net/webelements/alerts");
        System.out.println("Page title: " + driver.getTitle());
        
        driver.findElement(By.id("confirmation")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("alert message : "+alert.getText());
        alert.accept();
        
        String res = driver.findElement(By.id("result")).getText();
        System.out.println("The message after accepting alert : "+res);
        
        driver.findElement(By.id("confirmation")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        System.out.println("alert message : "+alert1.getText());
        alert.dismiss();
        
        String res1 = driver.findElement(By.id("result")).getText();
        System.out.println("The message after cancel : "+res1);
        
        driver.quit();
    }
}
