package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Google {
  public static void main(String[] args) {
    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();
    
    // Open the browser
    driver.get("https://www.google.com/");

    // Perform testing and assertions
    
    WebElement element = driver.findElement(By.id("APjFqb"));
    String attValue = element.getAttribute("id");
    String attValue1 = element.getAttribute("class");
    String attValue2 = element.getAttribute("name");
    
    System.out.println("id="+attValue + " name="+attValue2 + " class="+attValue1 );
    
    // Close the browser
    // Feel free to comment out the line below
    // so it doesn't close too quickly
    driver.quit();
  }
}