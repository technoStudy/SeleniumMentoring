package Sena.M3_TestNG_XML.TechnoStudyWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ApplyNow {
    private ChromeDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/RefiaSena/Downloads/chromedriverV83");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();

        driver.get("https://techno.study");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void selectContactUs() {

        WebElement applyNowTopNav = driver.findElement(By.xpath("//ul[@id='top-menu']/li[@id='menu-item-142']/a"));
        applyNowTopNav.click();

        // testing / asserting the URL

        String actual = driver.getCurrentUrl();
        String expected = "https://techno.study/apply-now/";
        Assert.assertEquals(actual, expected, "The URL is incorrect");

    }

    // more work coming for regression

    @AfterClass
    public void quit () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }
}
