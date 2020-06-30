package Zeynep.basic_Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Second {
    public static void main(String[] args) throws InterruptedException {
        /*
            https://www.techlistic.com
            Maximize or set size of browser window
            Click on 'Java' Tutorial link and validate page title.
            Navigate back to Home Page.
            Click on 'Selenium WebDriver'  Tutorial link and validate page title.
            Navigate back to Home Page.
            Click on 'Selenium IDE'  Blogs link and validate page title.
            Navigate back to Home Page.
            Click on 'TestNG' Blogs link and validate page title.

         */

        System.setProperty("webdriver.chrome.driver", "/Users/AKMERCAN/Desktop/Selenium/Chrome Driver/chromedriver-4");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser
        driver.get("https://www.techlistic.com");

        //Maximize or set size of browser window
        //driver.manage().window().maximize();

        //Click on 'Java' Tutorial link and validate page title.
        driver.findElement(By.cssSelector("#LinkList3>.widget-content>ul>li:nth-child(4)>a")).click();


        //Navigate back to Home Page.
        driver.navigate().back();

        //Click on 'Selenium WebDriver'  Tutorial link and validate page title.
        driver.findElement(By.cssSelector("#LinkList3>.widget-content>ul>li:nth-child(1)>a")).click();


        //Navigate back to Home Page.
        driver.navigate().back();



        //Click on 'Selenium IDE'  Blogs link and validate page title.
        driver.findElement(By.cssSelector("#LinkList2>.widget-content>ul>li:nth-child(5)>a")).click();
        Thread.sleep(1000);


        //Navigate back to Home Page.
        driver.navigate().back();


        //Click on 'TestNG' Blogs link and validate page title.
        driver.findElement(By.cssSelector(".overflowable-contents>.container>ul>li:nth-child(7)>a")).click();
        Thread.sleep(1000);





    }
}
