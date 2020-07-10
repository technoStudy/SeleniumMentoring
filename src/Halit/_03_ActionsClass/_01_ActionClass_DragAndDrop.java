package Halit._03_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _01_ActionClass_DragAndDrop {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement bank = driver.findElement(By.xpath("//a[contains(text(),'BANK')]"));

        WebElement sales = driver.findElement(By.xpath("//a[contains(text(),'SALES')]"));

        WebElement num5000 = driver.findElement(By.xpath("(//a[contains(text(),'5000')])[2]"));

        WebElement bankAccount = driver.findElement(By.xpath("//ol[@id='bank']"));

        WebElement bankAmount = driver.findElement(By.xpath("//ol[@id='amt7']"));

        WebElement creditAccount = driver.findElement(By.xpath("//ol[@id='loan']"));

        WebElement creditAmount = driver.findElement(By.xpath("//ol[@id='amt8']"));

        Actions action = new Actions(driver);

        action.dragAndDrop(bank,bankAccount).perform();

        action.dragAndDrop(sales, creditAccount).perform();

        action.dragAndDrop(num5000, bankAmount).perform();

        action.dragAndDrop(num5000, creditAmount).perform();






    }

}
