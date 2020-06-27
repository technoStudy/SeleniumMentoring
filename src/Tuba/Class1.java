package Tuba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Class1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // go to the website
        driver.get("http://newtours.demoaut.com");
        // click on sign on tab
        WebElement signOnbutton = driver.findElement(By.cssSelector("tr>td[class]:nth-child(1)"));
        signOnbutton.click();
        // enter the credentials to the username box
        WebElement userName = driver.findElement(By.cssSelector("tr input[name='userName']"));
        userName.sendKeys("ttorun");
        // enter the credentials to the password box
        WebElement password = driver.findElement(By.cssSelector("tr input[name='password']"));
        password.sendKeys("12345678");
        // click on sign in button
        WebElement submitButton = driver.findElement(By.xpath("//input[@name='login']"));
        submitButton.click();
        // selecting the trip type
        WebElement tripType = driver.findElement(By.cssSelector("input[name='tripType']:last-child"));
        tripType.click();
        // clicking on passenger tab
         WebElement passenger = driver.findElement(By.cssSelector("select[name='passCount']"));
        passenger.click();

        Thread.sleep(2000);
        // selecting the passenger count
        //  WebElement two = driver.findElement(By.cssSelector("select[name='passCount']>option[value='3']"));
        // two.click();
        List<WebElement> pass = driver.findElements(By.cssSelector("select[name='passCount']>option"));
        System.out.println(pass.size());
        pass.get(3).click();

        // selecting the departure
        WebElement departFrom = driver.findElement(By.cssSelector("select[name=fromPort]>[value=London]"));
        departFrom.click();
        // selecting the departure month
        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']/option[@value='7']"));
        fromMonth.click();
        // selecting the departure day
        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']/option[@value='7']"));
        fromDay.click();
        Thread.sleep(2000);
        // selecting the arrival destination
        // driver.findElement(By.cssSelector("select[name=toPort]")).click();
        WebElement arriveIn = driver.findElement(By.cssSelector("select[name=toPort]>[value=Frankfurt]"));
        arriveIn.click();
        Thread.sleep(2000);
        // returning day
        WebElement returnDay = driver.findElement(By.xpath("//select[@name='toDay']/option[@value='7']"));
        returnDay.click();
        // selecting the service class
        WebElement serviceClass = driver.findElement(By.xpath("//input[@value='Business']"));
        serviceClass.click();
        // selecting the airline
        WebElement airline = driver.findElement(By.xpath("//*[text()='Blue Skies Airlines']"));
        airline.click();
        // click  on continue button
        WebElement continueButton = driver.findElement(By.cssSelector("input[name='findFlights']"));
        continueButton.click();

    }
}
