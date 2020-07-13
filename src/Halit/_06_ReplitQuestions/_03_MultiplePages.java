package Halit._06_ReplitQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _03_MultiplePages {


    /**Navigate to  https://business.twitter.com/en/solutions-new.html

     Get the title of the page (title1)

     Click on  Developer blog

     Get the title of the page (title 2)

     Title 1 and title 2 should NOT  be equal

     Close the current page

     Get the title of the page

     Print the title of the page (title 3)

     Title 1 and Title 3 should be equal

     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://business.twitter.com/en/solutions-new.html");


    }
}
