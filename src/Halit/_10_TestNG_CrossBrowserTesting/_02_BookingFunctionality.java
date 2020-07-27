package Halit._10_TestNG_CrossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class _02_BookingFunctionality extends _01_BaseDriver {

    @Test
    public void bookAHotel() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.urlContains("account"));

        WebElement homeButton = driver.findElement(By.xpath("//a[@title='home']"));

        homeButton.click();

        WebElement hotel = driver.findElement(By.xpath("//h5[contains(text(),'Malmaison Manchester')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", hotel);

        hotel.click();

        WebElement seePriceButton = driver.findElement(By.xpath("//a[contains(text(),'See price and date')]"));

        seePriceButton.click();

        WebElement selectRoom = driver.findElement(By.xpath("(//label[@class='custom-control-label text-left go-left'])[1]"));

        wait.until(ExpectedConditions.elementToBeClickable(selectRoom));

        selectRoom.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@class='book_button btn btn-success btn-block btn-lg chk']"));

        js.executeScript("window.scrollBy(0,300)");

        submitButton.click();

        WebElement confirmButton = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block completebook']"));

        js.executeScript("arguments[0].scrollIntoView();", confirmButton);

        confirmButton.click();

        WebElement payOnArrivalButton = driver.findElement(By.xpath("//button[@class='btn btn-default arrivalpay']"));

        Thread.sleep(2000);

        payOnArrivalButton.click();

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='success-box reserved']"));

        wait.until(ExpectedConditions.visibilityOf(successMessage));

        if (successMessage.getText().contains("Your booking status is Reserved")){

            System.out.println("Your booking successfully completed!");

        }else {

            System.out.println("Your booking is not completed");

        }

    }

}
