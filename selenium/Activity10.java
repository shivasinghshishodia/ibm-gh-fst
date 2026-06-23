package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        driver.get("https://training-support.net/webelements/mouse-events");
        System.out.println("Page title: " + driver.getTitle());
        
        WebElement cl = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
        WebElement ct = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
        WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
        WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));
        
        builder.click(cl).pause(1000).build().perform();
        WebElement res = driver.findElement(By.id("result"));
        System.out.println(res.getText());
        
        builder.click(ct).pause(1000).build().perform();
        System.out.println(res.getText());
        
        builder.doubleClick(src).pause(1000).build().perform();
        System.out.println(res.getText());
        
        builder.contextClick(target).pause(1000).build().perform();
        System.out.println(res.getText());
        
        builder.click(driver.findElement(By.xpath("//*[@id='menu']/div/ul/li[1]"))).pause(1000).build().perform();
        System.out.println(res.getText());
        
        driver.quit();
    }
}