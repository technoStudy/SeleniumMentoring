package Yusuf.SeleniumProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/yusufesenboga/Selenium/Chrome Driver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.snapdeal.com/");

        driver.manage().window().maximize();

        driver.findElement(By.id("inputValEnter")).sendKeys("teddy bear");

        driver.findElement(By.className("searchformButton")).click();

        System.out.println(driver.findElement(By.id("searchMessageContainer")).getText());

        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.className("notIeLogoHeader")).click();

        System.out.println(driver.getCurrentUrl());

        driver.close();
    }
}
