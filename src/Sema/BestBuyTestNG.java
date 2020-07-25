package Sema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BestBuyTestNG {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDependency\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //go to website
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();
        //close popup
        WebElement closePopUp = driver.findElement(By.cssSelector("button[class='c-close-icon  c-modal-close-icon']"));
        closePopUp.click();
    }
    @Test
    public void test1()throws InterruptedException {
     // Thread.sleep(4000);

        WebElement search=driver.findElement(By.cssSelector("input[class='search-input']"));
        search.sendKeys("ipad");
        //click search button
        WebElement clickSearchButton=driver.findElement(By.cssSelector("button[class='header-search-button']"));
        clickSearchButton.click();
        //verify
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("ipad"));
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }


}
