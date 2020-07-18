package Sena.M2_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class HandleAlerts {
    private static WebDriver driver;

    // Today's outline:
    // What are alerts? Different kinds of alerts
    // How to handle them?
    // Accepting, cancelling, getting the message of the alert, writing to an inbox, checking a checkbox?


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/RefiaSena/Downloads/chromedriverV83");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


//        WebDriverWait wait = new WebDriverWait(driver, 2000);
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alert = driver.switchTo().alert();

//        WebElement okButton = driver.findElement(By.xpath("dkhk"));
//        okButton.click();

//        alert.accept();
//        alert.dismiss();
//        alert.sendKeys(",kjg");
//        alert.getText();


        // Task 1: Please fill in the form, DON'T CHECK THE CHECKBOX, then submit, you will have alert, accept it
        driver.get("https://www.browserstack.com/users/sign_up");

        WebElement gotItAlert = driver.findElement(By.xpath("//*[@class='btn btn-primary cookie-notification__got-it-cta js__accept-cookie']"));
        gotItAlert.click();

        String fullname = "Bob Ross";
        String email = "abc123jhcljhsljclh@gmail.com";
        String password = "abc123+S";

        WebElement fullnameInput = driver.findElement(By.xpath("//input[@placeholder = 'Full name']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder = 'Business Email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
        WebElement signupButton = driver.findElement(By.xpath("//input[@value = 'Sign me up']"));

        fullnameInput.sendKeys(fullname);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        signupButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);

        alert.dismiss();



    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
