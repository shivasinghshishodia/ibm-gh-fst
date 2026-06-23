package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
  public static void main(String[] args) {
    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();
    
    // Open the browser
    driver.get("https://training-support.net/webelements/login-form/");

    // Perform testing and assertions
    
    System.out.println(driver.getTitle());
    WebElement user = driver.findElement(By.name("username"));
    user.sendKeys("admin");
    WebElement pass = driver.findElement(By.name("password"));
    pass.sendKeys("password");
    
    driver.findElement(By.xpath("//button[text()='Submit']")).click();
    driver.quit();
  }
}


