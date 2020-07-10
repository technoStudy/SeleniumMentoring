package Sema.AlertAndIframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Alert  {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDependency\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //go to web site
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        //maximinize the window
        driver.manage().window().maximize();
        //click on action dialog button
        driver.findElement(By.id("action")).click();
        //if need use expicity wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("dialog-mycodemyway-action"))));
        //click on the ok button
        driver.findElement(By.id("dialog-mycodemyway-action")).click();
        //accept the iframe message
        driver.switchTo().alert().accept();

    driver.quit();
    }
}
