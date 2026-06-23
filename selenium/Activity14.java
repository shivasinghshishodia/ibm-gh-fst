package selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {
    public static void main(String[] args) {
        // Initialize the Firefox driver
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/tables");
        System.out.println("Page title: " + driver.getTitle());
        List<WebElement> cols=driver.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println("The number of colums are : "+cols.size());
        
        List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("The number of rows are : "+rows.size());
        
        WebElement value1 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        System.out.println("book name before sorting : "+value1.getText());
        
        driver.findElement(By.xpath("//table/thead/tr/th[5]")).click();
        
        WebElement value2 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        System.out.println("book name after sorting : "+value2.getText());
        
        driver.quit();
        
        
    }
}
