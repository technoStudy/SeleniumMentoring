package Halit._05_ScrollDown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class _02_ScrollDownBasics_ToElement {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.espn.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement WorkdayCharity = driver.findElement(By.xpath("//h1[text()='WORKDAY CHARITY OPEN']"));

        // Scroll to Element
        js.executeScript("arguments[0].scrollIntoView();", WorkdayCharity);

        Thread.sleep(2000);

        WebElement topHeadlines = driver.findElement(By.xpath("//h1[text()=' Top Headlines']"));

        // Scroll back to upper element
        js.executeScript("arguments[0].scrollIntoView();", topHeadlines);


    }

}
