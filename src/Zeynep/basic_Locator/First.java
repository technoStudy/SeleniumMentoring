package Zeynep.basic_Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/AKMERCAN/Desktop/Selenium/Chrome Driver/chromedriver-4");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");


        //fill the firstname
        driver.findElement(By.name("firstname")).sendKeys("zeynep");

        //fill the firstname
        driver.findElement(By.name("lastname")).sendKeys("ucar");

        //check the gender
        driver.findElement(By.id("sex-1")).click();

        //check the experience
        driver.findElement(By.id("exp-1")).click();

        //fill the date
        driver.findElement(By.id("datepicker")).sendKeys("10/04/2019");

        //choose your profession
        driver.findElement(By.id("profession-1")).click();

        //choose your tool
        driver.findElement(By.id("tool-2")).click();

        //choose your continent
        driver.findElement(By.cssSelector("option:nth-of-type(7)")).click();

        //choose your command
        driver.findElement(By.cssSelector("#selenium_commands > option:nth-child(5)")).click();

        //click submit button
        driver.findElement(By.className("btn btn-info")).click();







    }
}
