package Halit._04_SwitchWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class _01_SwitchToWindow {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.naukri.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        String firstURL = driver.getCurrentUrl();

        Set<String> allWindows = driver.getWindowHandles();

        for (String handle : allWindows) {

            driver.switchTo().window(handle);

        }

        String secondURL = driver.getCurrentUrl();

        System.out.println(firstURL);

        System.out.println(secondURL);

        driver.close();

        allWindows = driver.getWindowHandles();

        for (String handle : allWindows) {

            driver.switchTo().window(handle);

        }

        String thirdURL = driver.getCurrentUrl();
        System.out.println(thirdURL);

        String parentWindow = driver.getWindowHandle();

        Actions action = new Actions(driver);

        WebElement companies = driver.findElement(By.xpath("//div[text()='Companies']"));

        action.moveToElement(companies).perform();

        WebElement browseAllCompanies = driver.findElement(By.cssSelector("a[title='Browse All Companies']"));

        action.moveToElement(browseAllCompanies).click().perform();

        allWindows = driver.getWindowHandles();

        for (String handle : allWindows) {

            driver.switchTo().window(handle);

        }

        String fourthURL = driver.getCurrentUrl();

        System.out.println(fourthURL);

        driver.findElement(By.cssSelector("input[placeholder=\"Skills, Designations, Companies\"]")).sendKeys("Java");

        driver.findElement(By.cssSelector("button[id='qsbFormBtn']")).click();

        driver.switchTo().window(parentWindow);

        driver.quit();

    }

}
