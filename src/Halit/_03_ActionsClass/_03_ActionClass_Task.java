package Halit._03_ActionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _03_ActionClass_Task {

    /**                   TASK
     * Navigate to "https://www.espn.com/"
     * MoveToElement "Soccer"
     * MoveToElement "Barcelona" and click
     * MoveToElement "Fixtures"
     * MoveToElement "Results" and click
     * Print last game result of Barcelona
     */


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.espn.com/");

        Actions action = new Actions(driver);


    }


}











