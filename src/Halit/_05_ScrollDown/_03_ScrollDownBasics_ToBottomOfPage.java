package Halit._05_ScrollDown;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class _03_ScrollDownBasics_ToBottomOfPage {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.espn.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(2000);

        // Scroll down to bottom of the page
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        Thread.sleep(2000);

        // Scroll back to top
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

}
