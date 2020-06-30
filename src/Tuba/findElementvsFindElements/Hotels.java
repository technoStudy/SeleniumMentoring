package Tuba.findElementvsFindElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

import java.util.List;

public class Hotels {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hotels.com/");

        WebElement destination = driver.findElement(By.xpath("//input[@name='q-destination']"));
        destination.sendKeys("New York, New York, United States of America");
        WebElement close=driver.findElement(By.xpath("//button[text()='close']"));
        close.click();

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        List<WebElement> prices=driver.findElements(By.xpath("//div//ins"));
        for (int i = 0; i <prices.size() ; i++) {
            String s1 = prices.get(i).getText();
            s1 = s1.replace("$", "");
            //  System.out.println(prices.get(i).getText());
            int price = Integer.parseInt(s1);
            if (price < 100) {
                System.out.println(price);
            }
        }
    }
}
