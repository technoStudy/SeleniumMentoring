package Halit._04_SwitchWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class _02_SwitchToWindow {

    /**
     *                              _00_Task
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

        driver.get("https://www.naukri.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        String firstURL = driver.getCurrentUrl();

        Set<String> allWindows = driver.getWindowHandles();

        for (String handle: allWindows) {

            driver.switchTo().window(handle);

        }

        String secondURL = driver.getCurrentUrl();

        driver.close();

        allWindows = driver.getWindowHandles();

        for (String handle: allWindows) {

            driver.switchTo().window(handle);

        }

        String parentWindow = driver.getWindowHandle();

        Actions action = new Actions(driver);

        WebElement tools = driver.findElement(By.xpath("//div[contains(text(),'Tools')]"));

        action.moveToElement(tools).perform();

        WebElement salaryTrends = driver.findElement(By.xpath("//a[@title='Salary Trends']"));

        action.moveToElement(salaryTrends).click().perform();

        allWindows = driver.getWindowHandles();

        for (String handle : allWindows){

            driver.switchTo().window(handle);

        }

        String thirdURL = driver.getCurrentUrl();

        driver.switchTo().window(parentWindow);

        String fourthURL = driver.getCurrentUrl();

        System.out.println(firstURL);
        System.out.println(secondURL);
        System.out.println(thirdURL);
        System.out.println(fourthURL);

        driver.quit();

    }

    }

