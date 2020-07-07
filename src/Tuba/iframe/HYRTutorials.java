package Tuba.iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HYRTutorials {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

        driver.findElement(By.xpath("//input[@class='frmTextBox']")).sendKeys("Hello Main Page");

       // Thread.sleep(2000);
        driver.switchTo().frame("frm1");
        WebElement course=driver.findElement(By.id("course"));

        Select select=new Select(course);
        select.selectByVisibleText("Java");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frm3");
        driver.findElement(By.xpath("//input[@class='frmTextBox']")).sendKeys("Hello Frame 3");
        driver.switchTo().frame("frm1");
        WebElement course3=driver.findElement(By.id("course"));

        Select selectFrame3=new Select(course3);
        selectFrame3.selectByVisibleText("Python");

        driver.switchTo().parentFrame(); // if I wanna go back to frame3 from frame 1








        //
    }
}
