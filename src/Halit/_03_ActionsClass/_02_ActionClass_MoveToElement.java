package Halit._03_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class _02_ActionClass_MoveToElement {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.espn.com/");

        Thread.sleep(4000);

        WebElement nba = driver.findElement(By.xpath("//a[@name='&lpos=sitenavdefault+sitenav_nba']"));

        WebElement lakers = driver.findElement(By.xpath("//span[@class='link-text'][contains(text(),'Los Angeles Lakers')]"));

        Actions action = new Actions(driver);

        action.moveToElement(nba).perform();

        Thread.sleep(2000);

        action.moveToElement(lakers).click().perform();

        Thread.sleep(3000);

        WebElement home = driver.findElement(By.xpath("//a[@name='&lpos=subnav+subnav_nba_index']"));

        WebElement stats = driver.findElement(By.xpath("//a[@name='&lpos=subnav+subnav_nba_stats']"));

        WebElement schedule = driver.findElement(By.xpath("//a[@name='&lpos=subnav+subnav_nba_schedule']"));

        WebElement roster = driver.findElement(By.xpath("//a[@name='&lpos=subnav+subnav_nba_roster']"));

        WebElement injuries = driver.findElement(By.xpath("//a[@name='&lpos=subnav+subnav_nba_injuries']"));

        action.moveToElement(home).perform();

        Thread.sleep(3000);

        action.moveToElement(stats).perform();

        Thread.sleep(3000);

        action.moveToElement(schedule).perform();

        Thread.sleep(3000);

        action.moveToElement(roster).perform();

        Thread.sleep(3000);

        action.moveToElement(injuries).click().perform();

        Thread.sleep(4000);

        List<WebElement> injuriedPlayers = driver.findElements(By.xpath("//h3[@class='di n8']"));

        List<String> injuriedPlayerString = new ArrayList<>();

        for (int i = 0; i < injuriedPlayers.size(); i++){

            String injuriedPlayer = injuriedPlayers.get(i).getText();

            injuriedPlayerString.add(injuriedPlayer);

        }

        System.out.println(injuriedPlayerString);

        driver.close();

    }

}

