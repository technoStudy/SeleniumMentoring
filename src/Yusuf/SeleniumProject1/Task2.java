package Yusuf.SeleniumProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/yusufesenboga/Selenium/Chrome Driver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.applitools.com/");

        driver.manage().window().maximize();

        driver.findElement(By.id("username")).sendKeys("ttechno@gmail.com");

        driver.findElement(By.id("password")).sendKeys("techno123.");

        driver.findElement(By.id("log-in")).click();

        System.out.println(driver.findElement(By.id("time")).getText());

        System.out.println(driver.getCurrentUrl());

        driver.close();
    }
}
