package Halit._06_ReplitQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class _02_Dropdown3 {


    /**
     * Navigate to  https://www.saucedemo.com/
     * <p>
     * Enter the user name  as standard_user
     * <p>
     * Enter the password as   secret_sauce
     * <p>
     * Click on login button
     * <p>
     * Choose price low to high
     * <p>
     * Verify item prices are sorted from low to high
     */


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));

        username.sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        WebElement selectLowtoHigh = driver.findElement(By.xpath("//select[@class='product_sort_container']"));

        Select slc = new Select(selectLowtoHigh);

        slc.selectByVisibleText("Price (low to high)");

        List<WebElement> itemList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        ArrayList<Double> doubleItemPrice = new ArrayList<>();

        changeStringToDouble(itemList, doubleItemPrice);

        System.out.println(doubleItemPrice);

        verifyList(doubleItemPrice);


    }

    public static void changeStringToDouble (List<WebElement> itemList, ArrayList<Double> doubleList){

        for (int i =0; i < itemList.size(); i++) {

            String myString = itemList.get(i).getText(); // "$7.99"

            myString = myString.replaceAll("[^\\d.]", ""); // "7.99"

            double myD = Double.parseDouble(myString); // 7.99(double)

            doubleList.add(myD);

        }


    }

    public static void verifyList(ArrayList<Double> List){

        for (int i = 0; i < List.size() - 1; i++){

            if (List.get(i) <= List.get(i+1) ){

//                {1, 4, 8, 8, 56}

            }else
                System.out.println("There is a problem");

        }
        System.out.println("The List is sorted from Low to High");
    }


}
