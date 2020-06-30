package Tuba.findElementvsFindElements;

import okio.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DestroyPart {
    public static void main(String[] args) throws InterruptedException {
        /*
        Destroy the Ayse Turkmen from the list
         */
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("ttorun16@gmail.com");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> names = driver.findElements(By.xpath("//tr//td[1]"));

        List<WebElement> destroy = driver.findElements(By.xpath("//a[text()='Destroy']"));

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getText().equalsIgnoreCase("Ayse")) {
                destroy.get(i).click();
                driver.switchTo().alert().accept();

            }
        }

    }
}
