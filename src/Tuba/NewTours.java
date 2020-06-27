package Tuba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NewTours {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // go to the website
        driver.get("http://newtours.demoaut.com");

        // click on the SIGN-ON tab

        WebElement signOnTab = driver.findElement(By.cssSelector("tr>td[class]:nth-child(1)"));
        signOnTab.click();

        // fill out the username
        WebElement userNameBox = driver.findElement(By.cssSelector("input[name='userName']"));
        String username = "ttorun";
        userNameBox.sendKeys(username);

        // fill out the password

        WebElement passwordBox = driver.findElement(By.cssSelector("input[name='password']"));
        String password = "12345678";
        passwordBox.sendKeys(password);

        // click on the submit button

        WebElement submitButton = driver.findElement(By.cssSelector("input[name='login']"));
        submitButton.click();

        // select the trip type

        WebElement tripType = driver.findElement(By.cssSelector("input[type=radio][value=roundtrip]"));
        tripType.click();

        // select the pass count
        //WebElement passCount=driver.findElement(By.cssSelector("select[name='passCount']>option:nth-of-type(3)"));
        // passCount.click();
        // select[name='passCount']>option:nth-child(3)

        List<WebElement> passenger = driver.findElements(By.cssSelector("select[name='passCount']>option"));
        System.out.println(passenger.size());
        passenger.get(2).click();

        // select the departure
//
//        WebElement departure=driver.findElement(By.cssSelector("select[name='fromPort']>option[value='San Francisco']"));
//        departure.click();
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.cssSelector("select[name='fromPort']>option"));
        for (WebElement element : elements) {
            if (element.getText().equals("San Francisco")) {
                element.click();
            }
        }

           // select the month
        WebElement month=driver.findElement(By.xpath("//select[@name='fromMonth']//option[@value='6']"));
        month.click();
    }
}