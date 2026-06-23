package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        driver.get("https://training-support.net/webelements/drag-drop");
        System.out.println("Page title: " + driver.getTitle());
        
        WebElement football = driver.findElement(By.id("ball"));
        WebElement dz1 = driver.findElement(By.id("dropzone1"));
        WebElement dz2 = driver.findElement(By.id("dropzone2"));
        
        builder.clickAndHold(football).pause(1000).moveToElement(dz1).release().build().perform();
        String res= driver.findElement(By.xpath("//*[@id='dropzone1']/span")).getText();
        System.out.println("the status of dropzone 1 : "+res);
        
        builder.dragAndDrop(football, dz2).build().perform();
        String res2 = driver.findElement(By.xpath("//*[@id=\'dropzone2\']/span")).getText();
        System.out.println("the status of dropzone 2 : "+res2);
        
        driver.quit();
    }
}