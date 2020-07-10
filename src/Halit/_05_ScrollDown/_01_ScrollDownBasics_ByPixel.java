package Halit._05_ScrollDown;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class _01_ScrollDownBasics_ByPixel {

    /**
     *      By Pixel
     *      To Element
     *      To Bottom of the Page
     */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.espn.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll by Pixel
        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(2000);

        // Scroll back by Pixel
        js.executeScript("window.scrollBy(0,-500)");

    }



}
