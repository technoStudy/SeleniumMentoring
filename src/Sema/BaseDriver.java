package Sema;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

public class BaseDriver {
    protected WebDriver driver;
    protected Actions builder;

    @BeforeClass
   public void setupWebsite(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDependency\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        builder = new Actions(driver);
    }

//    @AfterClass
//    public void closeDriver(){
//        driver.quit();
//    }
}
