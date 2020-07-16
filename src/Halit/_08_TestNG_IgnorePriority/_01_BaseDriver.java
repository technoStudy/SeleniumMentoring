package Halit._08_TestNG_IgnorePriority;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _01_BaseDriver {

    protected WebDriver driver;

    @BeforeClass
    public void login(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/index.html");

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("user-name"));

        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));

        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));

        loginButton.click();

    }

    @AfterClass
    public void quit(){

        driver.quit();

    }

}
