package Sema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsBestBuy {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDependency\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();

        //printout "Don't miss out on the latest deals and more."
       WebElement findCourse=driver.findElement(By.id("email-submission-title-1b1abf1b-2bef-41a2-ad44-0917161f32f2"));
        System.out.println(findCourse.getText());

        //close pop-up
        WebElement closeButton=driver.findElement(By.cssSelector("button[class='c-close-icon  c-modal-close-icon']"));
       // WebElement closeButton=driver.findElement(By.xpath("//button[@class='c-close-icon  c-modal-close-icon']"));
        closeButton.click();

        Thread.sleep(1000);

        //search Ipad
       WebElement search=driver.findElement(By.cssSelector("input[class='search-input']"));
        //WebElement search=driver.findElement(By.xpath("//input[@class='search-input']"));
        search.sendKeys("Ipad");
        Thread.sleep(1000);

        //click search button
        WebElement clickSearchButton=driver.findElement(By.cssSelector("button[class='header-search-button']"));
       // WebElement clickSearchButton=driver.findElement(By.xpath("//button[@class='header-search-button']"));
        clickSearchButton.click();


       WebElement clickIpad=driver.findElement(By.cssSelector("ul[class='nav-menu-links']>li:nth-child(3)"));
       clickIpad.click();


       WebElement clickIpadAir=driver.findElement(By.cssSelector("div[class='dropdown-active panel-1  secondary-navigation-dropdown-container']>div>div>ul>li:nth-child(2)"));
       clickIpadAir.click();

       WebElement getIpad11=driver.findElement(By.cssSelector("h1[class='heading-5 v-fw-regular']"));
        System.out.println(getIpad11.getText());

        //printout current URL
         System.out.println(driver.getCurrentUrl());

        // Thread.sleep(10000);
         driver.quit();
    }
}
