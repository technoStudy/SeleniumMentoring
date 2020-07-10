package Halit._05_ScrollDown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _04_ScrollDown_Task {

    /**
     *                          Task
     *      -> Hover-Over on Soccer
     *      -> Click on Borussia Dortmund
     *      -> Scroll Down until you get 50th news
    */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.espn.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement SoccerButton = driver.findElement(By.xpath("//a[@name='&lpos=sitenavdefault+sitenav_soccer']"));

        action.moveToElement(SoccerButton).perform();

        WebElement borussiaDortmund = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='&lpos=subnav+subnav_soccer_team_borussia_dortmund']")));

        action.moveToElement(borussiaDortmund).click().perform();

        // We are getting all the News List to find 50th Element
        List<WebElement> newsList = driver.findElements(By.xpath("//a[@class=' realStory']"));

        System.out.println(newsList.size());

        while (newsList.size() <= 50) {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            /*           Scroll to last element in the List
                    Why we used -1?
                        Because hotelList.size() start counting from 1
                        hotelList.get() start counting from 0
                        if don't use it List will throw
                        "ArrayIndexOutOfBoundException"
  */

            js.executeScript("arguments[0].scrollIntoView();", newsList.get(newsList.size()-1));

            newsList = driver.findElements(By.xpath("//a[@class=' realStory']"));

            System.out.println(newsList.size());

        }

        System.out.print("Here is the 50th news -->  ");
        System.out.print(newsList.get(49).getText());

    }

}
