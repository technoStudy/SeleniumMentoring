package Zeynep.switchWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class Topic {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/AKMERCAN/Desktop/Selenium/Chrome Driver/chromedriver-4");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser
        driver.get("https://www.selenium.dev/");

        String windowHandle = driver.getWindowHandle();
        System.out.println("tek windowken " + windowHandle);

        List<WebElement> elements = driver.findElements(By.cssSelector("a[target=_blank]"));

        for (WebElement element : elements) {
            element.click();
        }
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {

            System.out.println("birden cok " + handle);

            if (!handle.equals(windowHandle)){
                driver.switchTo().window(handle);
                System.out.println(driver.getTitle());
            }

        }
        driver.quit();


    }
}
