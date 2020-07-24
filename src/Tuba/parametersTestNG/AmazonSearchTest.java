package Tuba.parametersTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearchTest {

    public WebDriverWait wait;
    public WebDriver driver;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @BeforeClass
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 6);
    }

    @BeforeMethod

    public void goToTheWebsite() {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 6);


    }

    @Test(alwaysRun = true)
    @Parameters({"searchItem"})
    public void searchFirst100Words(String searchItem) throws InterruptedException {
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#twotabsearchtextbox")));
        driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys(searchItem);
        WebElement searchButton = driver.findElement(By.cssSelector(" input[value='Go']"));
        searchButton.click();


    //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='The Wonderful Things You Will Be']")));


        List<WebElement> books = driver.findElements(By.xpath("//span[contains(text(),'Best Seller')]/ancestor::div[@class='a-section a-spacing-medium']//h2"));

        System.out.println(books.size());
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).getText());

        }


    }


}
