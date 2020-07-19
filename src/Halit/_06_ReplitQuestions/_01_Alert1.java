//package Halit._06_ReplitQuestions;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.jar.JarEntry;
//
//public class _01_Alert1 {
//
//    /**
//     * Navigate to "https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/"
//     *
//     * Click on "Simple Alert" button
//     *
//     * Accept the alert
//     */
//
//
//    public static void main(String[] args) throws InterruptedException {
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//
//        driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
//
//        Thread.sleep(5000);
//
//        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[text()='Simple Alert']"));
//
//        simpleAlertButton.click();
//
//        Thread.sleep(2000);
//
//        driver.switchTo().alert().accept();
//
//        Thread.sleep(2000);
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        js.executeScript("window.scrollBy(0,200)");
//
//        WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Confirm Pop up']"));
//
//        confirmButton.click();
//
//        driver.switchTo().alert().dismiss();
//
//        String message = driver.findElement(By.xpath("//span[@id='ConfirmOption']")).getText();
//
////        Assert.assertEquals(message, "You have clicked on Cancel");
//
//
//
//    }
//}
