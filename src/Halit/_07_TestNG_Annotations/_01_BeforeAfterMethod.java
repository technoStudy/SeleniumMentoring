package Halit._07_TestNG_Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class _01_BeforeAfterMethod {

    WebDriver driver;

    @BeforeMethod // Before method is running before each @Test!!
    public void BeforeMethod() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.manage().window().maximize();

    }

    @Test (priority = 2)
    public void Test1() {

        WebElement costumerID = driver.findElement(By.xpath("//input[@name='cusid']"));

        costumerID.sendKeys("14725836");

        WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));

        submitButton.click();

        driver.switchTo().alert().accept(); // if I comment this only 1 Test will fail because @BeforeMethod is opening browsers for each @Test

        String alertMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(alertMessage, "Customer Successfully Delete!");

        driver.switchTo().alert().accept();

        String URL = driver.getCurrentUrl();

        Assert.assertEquals(URL, "http://demo.guru99.com/test/delete_customer.php");

    }

    @Test (priority = 1)
    public void Test2(){

        WebElement bankProjectButton = driver.findElement(By.linkText("Bank Project"));

        bankProjectButton.click();

        WebElement userId = driver.findElement(By.xpath("//input[@name='uid']"));

        userId.sendKeys("456789");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

        password.sendKeys("12346755");

        WebElement loginButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));

        loginButton.click();

        String alertMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(alertMessage, "User is not valid");

        driver.switchTo().alert().accept();

        String Url = driver.getCurrentUrl();

        Assert.assertEquals(Url, "http://demo.guru99.com/V1/index.php");

    }

    @AfterMethod // After Method is running after each @Test
    public void AfterMethod(){

        driver.quit();

    }

}