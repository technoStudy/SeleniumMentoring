package Zeynep.basic_Locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Second {
    public static void main(String[] args) {
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




    }
}
