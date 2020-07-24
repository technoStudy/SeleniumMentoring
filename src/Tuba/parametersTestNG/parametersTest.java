package Tuba.parametersTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class parametersTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,6);
    }

    @Test
    @Parameters({"number1"})
    void PrimeTest(String number1) {
        boolean isPrime = false;
        int number = Integer.parseInt(number1);
        if (number < 2) {
            Assert.fail( number1+" is not a prime");
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                Assert.fail( number1+" is not a prime");
            } else {
                isPrime = true;
                Assert.assertTrue(isPrime, "your number is a prime");
            }
        }


    }

    @Test
    @Parameters({"num"})
    void armStrongNumber(String num) {
        boolean isStrong = false;
        int number = Integer.parseInt(num);

        int sum = 0;
        int originalNum = number;
        while (originalNum > 0) {

            int remainder = originalNum % 10;
            sum += remainder * remainder * remainder;

            originalNum /= 10;
        }

        if (sum == number) {
            isStrong = true;
            Assert.assertTrue(isStrong,num+" is a armstrong number");
        } else {

            Assert.fail(num+" is not a armstrong number");
        }
    }

    @Test(enabled = false)
    @Parameters({"min", "max", "numm", "numm2", "destination"})
    void hotels(String min, String max, String numm, String numm2, String Destination) throws InterruptedException {

        float minn = Float.parseFloat(min);
        float maxx = Float.parseFloat(max);
        int num = Integer.parseInt(numm);
        int num2 = Integer.parseInt(numm2);
        WebDriverWait wait = new WebDriverWait(driver, 6);
        driver.manage().window().maximize();

        driver.get("https://www.hotels.com/");

        driver.findElement(By.xpath("//button[@aria-label='Close overlay']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q-destination']")));


        WebElement destination = driver.findElement(By.xpath("//input[@name='q-destination']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(destination).click()
                .sendKeys(Destination)
                .perform();
        Thread.sleep(2000);

        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();



        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-labelledby='f-price-min-label']")));

        WebElement minLabel = driver.findElement(By.xpath("//div[@aria-labelledby='f-price-min-label']"));

        WebElement slider = driver.findElement(By.cssSelector("#filter-price div.widget-slider-cont"));

        int width = slider.getSize().getWidth();

        System.out.println(width);

        int offsetX = (int) (width / (maxx - minn) * num);
        System.out.println(offsetX);
        actions.dragAndDropBy(minLabel, offsetX, 0).click();
        actions.build().perform();

        WebElement maxLabel = driver.findElement(By.xpath("//div[@aria-controls='f-price-max']"));
        int offsetNX = -(int) (width / (maxx - minn) * num2);
        System.out.println(offsetNX);
        actions.dragAndDropBy(maxLabel, offsetNX, 0).click();
        actions.build().perform();
    }
}


