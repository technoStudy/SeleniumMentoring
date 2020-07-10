package Zeynep.switchWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Set;

public class Task {

    /*
    navigate to https://www.etsy.com/
    write earrings on search area and click
    choose one of them
    get the text of earrings
    select a color
    select an option
    select quantity
    and add to cart
    then verify name is the same with previous one
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/AKMERCAN/Desktop/Selenium/Chrome Driver/chromedriver-4");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser

        //navigate to https://www.etsy.com/
        driver.get("https://www.etsy.com/");

        //write earrings on search area and click
        WebElement element = driver.findElement(By.xpath("//input[@data-id='search-query']"));
        element.sendKeys("earrings");

        driver.findElement(By.cssSelector("span[class=\"etsy-icon wt-nudge-b-1\"]>svg")).click();

        //choose one of them
        driver.findElement(By.xpath("//h3[contains(text(),'Butterfly earrings')]")).click();

        String mainWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(mainWindowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }

        //get the text of earrings

        String text = driver.findElement(By.cssSelector("div[data-component=\"listing-page-title-component\"]>h1")).getText();
        System.out.println(text);

        //select a color
        driver.findElement(By.cssSelector("#inventory-variation-select-0>option:nth-child(5)")).click();

        //select an option
        driver.findElement(By.cssSelector("#inventory-variation-select-1>option:nth-child(2)")).click();

        //add to cart
        driver.findElement(By.cssSelector("button[type=\"submit\"]>div")).click();

        //get the text from cart

        String text_2 = driver.findElement(By.cssSelector("p[class=\"display-block pb-xs-1\"]>a")).getText();

        System.out.println(text_2);

        //verify two names
        Assert.assertEquals(text, text_2);

    }
}
