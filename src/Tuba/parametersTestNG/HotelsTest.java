package Tuba.parametersTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelsTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 6);
    }

    @Test
    @Parameters({"Destination","minPrice","maxPrice","ourPrice"})
    void NewYorkTest(String Destination, String minPrice, String maxPrice, String ourPrice) {
        Actions actions=new Actions(driver);
        driver.get("https://www.hotels.com/");

        WebElement crossSign = driver.findElement(By.cssSelector("button[aria-label='Close overlay']"));
        crossSign.click();

        WebElement destination = driver.findElement(By.id("qf-0q-destination"));
        destination.sendKeys(Destination);
        destination.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-labelledby='f-price-min-label']")));
        WebElement leftminSlider=driver.findElement(By.cssSelector("div[aria-controls='f-price-min']"));
        WebElement sliderStick = driver.findElement(By.cssSelector("#filter-price div.widget-slider-cont"));
        int width=sliderStick.getSize().getWidth();
        System.out.println(width);

        float min=Float.parseFloat(minPrice);
        float max=Float.parseFloat(maxPrice);

        int price=Integer.parseInt(ourPrice);


        int offsetX=(int)(price*width/(max-min));


        actions.dragAndDropBy(leftminSlider,offsetX,0).click().perform();

    }
}
