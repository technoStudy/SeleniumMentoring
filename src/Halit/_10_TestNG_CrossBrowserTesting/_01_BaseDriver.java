package Halit._10_TestNG_CrossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class _01_BaseDriver {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void navigateToWebsite(String browser){

        if (browser.equals("chrome")){

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

            driver = new ChromeDriver();

        }else if (browser.equals("firefox")){

            System.setProperty("webdriver.gecko.driver", "C:\\Users\\halit\\Documents\\Selenium\\geckodriver\\geckodriver.exe");

            driver = new FirefoxDriver();

        }

        driver.manage().window().maximize();

        driver.get("https://www.phptravels.net/home");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement loginDrpDwn = driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']"));

        loginDrpDwn.click();

        WebElement loginButton = driver.findElement(By.xpath("//a[@class='dropdown-item active tr']"));

        loginButton.click();

        WebElement email = driver.findElement(By.xpath("//input[@name='username']"));

        email.sendKeys("user@phptravels.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

        password.sendKeys("demouser");

        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']"));

        submitButton.click();


    }

    @AfterClass
    public void quit(){

        driver.quit();

    }

}
