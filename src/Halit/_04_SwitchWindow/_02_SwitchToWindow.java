package Halit._04_SwitchWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class _02_SwitchToWindow {

    /**
     *                              Task
     *        --> Navigate to "https://www.naukri.com/"
     *        --> Close second window
     *        --> Print current url
     *        --> Hover-over on "Tools" and click "Salary Trends"
     *        --> Print second window's url
     *        --> Navigate back to first window and print url again
     *        --> Close all windows
     *
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.naukri.com/");

        Thread.sleep(5000);
        String mainPageHandle = driver.getWindowHandle();

        changeWindow(driver);
        driver.switchTo().window(mainPageHandle); //to focus again our main page
        Thread.sleep(13000);
        driver.findElement(By.id("block")).click();

        System.out.println(driver.getCurrentUrl());

        Thread.sleep(7000);
        WebElement toolsButton = driver.findElement(By.xpath("(//div[@class='mTxt'])[4]"));
        Actions action = new Actions(driver);
        action.moveToElement(toolsButton).perform();

        driver.findElement(By.cssSelector("a[title=\"Salary Trends\"]")).click();

        changeWindow(driver);
        String url2 = driver.getCurrentUrl();
        System.out.println(url2);

        driver.switchTo().window(mainPageHandle);

        System.out.println(driver.getCurrentUrl());

        driver.close();
    }
    public static void changeWindow (WebDriver driver) {
        String mainPageHandle = driver.getWindowHandle();
        Set<String> windowHandlesNew = driver.getWindowHandles();
        for (String windowHandleNew : windowHandlesNew) {
            if(!windowHandleNew.equals(mainPageHandle)){
                driver.switchTo().window(windowHandleNew);
            }
        }
    }

    }

