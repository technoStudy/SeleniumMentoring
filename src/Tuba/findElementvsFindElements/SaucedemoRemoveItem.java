package Tuba.findElementvsFindElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SaucedemoRemoveItem {
    public static void main(String[] args) throws InterruptedException {
        /*
        TASK2
        Find the list of the item names
        if the item name is "Sauce Labs Bike Light" , add to cart
        After this step add 2 more items to the cart
        And remove the "Sauce Labs Bike Light" from the cart
         */
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/inventory.html");

    }
}