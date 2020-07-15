package Zeynep.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {

    /*
    @BeforeMethod
            it will run before each testCases
    @AfterMethod
            it will run after each testCases
    @BeforeClass
            it will run before the first test method in the current class is invoked
    @AfterClass
            it will run after all methods in the current class have been run

     */

    public WebDriver driver;
    public WebDriverWait wait;

   @BeforeClass
   void setup(){
       System.setProperty("webdriver.chrome.driver", "/Users/AKMERCAN/Desktop/Selenium/Chrome Driver/chromedriver-4");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);


   }

   @BeforeMethod
    void goToWebsite(){
       driver.get("http://thedemosite.co.uk/login.php");



   }

    public String username;
    public String password;

    @Test
    void loginToPage1(){
        username = "ali";
        password = "123";

       driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys(username);
       driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(password);
       driver.findElement(By.cssSelector("[name=\"FormsButton2\"]")).click();

       String text = driver.switchTo().alert().getText();
       driver.switchTo().alert().accept();

        Assert.assertEquals("Username too short.  The username must be at least 4 characters in length.", text);


    }

    @Test
    void loginToPage2(){

        username = "umare";
        password = "123";

        driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name=\"FormsButton2\"]")).click();

        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertEquals("Password too short.  The password must be at least 4 characters in length.", text);





    }



}
