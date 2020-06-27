package Yusuf.SeleniumProject1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/yusufesenboga/Selenium/Chrome Driver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://demoqa.com/text-box");
        driver.manage().window().maximize();

        driver.findElement(By.id("userName")).sendKeys("Automation");

        driver.findElement(By.id("userEmail")).sendKeys("Testing@gmail.com");

        driver.findElement(By.id("currentAddress")).sendKeys("Testing Current Address part 1");

        driver.findElement(By.id("permanentAddress")).sendKeys("Testing Current Address part 2");

        driver.findElement(By.id("submit")).click();

        System.out.println(driver.findElement(By.id("name")).getText());

        System.out.println(driver.findElement(By.id("email")).getText());

        driver.close();

    }
}