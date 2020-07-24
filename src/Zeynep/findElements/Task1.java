package Zeynep.findElements;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    /*

    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list

     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/AKMERCAN/Desktop/Selenium/Chrome Driver/chromedriver-4");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser

        //click on Phones & PDAs
        driver.findElement(By.xpath("//a[text()='Phones & PDAs']")).click();

        //get the brandName of phones

        List<WebElement> names = driver.findElements(By.cssSelector(".caption h4 a"));
        List<String> namesFromDisplay = getName(names);

        //need to sort it, but show later
        Collections.sort(namesFromDisplay);
        System.out.println(namesFromDisplay);

        //click on add to button for all elements

        //or .button-group>:first-child>:first-child
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"button-group\"]/button/i[@class=\"fa fa-shopping-cart\"]"));
        clickAllElements(elements);
        Thread.sleep(1000);

        //click on black total added cart button
        // or  #cart>button
        driver.findElement(By.xpath("//div[@id='cart']/button")).click();

        //get the names of list from the cart
        // or tr>.text-left>a
        List<WebElement> namesFromCart = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[@class=\"text-left\"]/a"));
        List<String> namesFromCartList = getName(namesFromCart);

        //need to sort it, but show later
        Collections.sort(namesFromCartList);
        System.out.println("--------" + namesFromCartList);

        //compare the names from displaying list and cart list
        compareTwoList(namesFromDisplay,namesFromCartList );




    }

    public static void clickAllElements(List<WebElement> list){

        for (WebElement webElement : list) {
            webElement.click();

        }
    }

    public static List<String> getName(List<WebElement> list){

        List<String> names = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            names.add(list.get(i).getText());
        }
        return names;
    }

    public static void compareTwoList(List<String> list1, List<String > list2){

        for (int i = 0; i < list1.size(); i++) {

            if (!list1.get(i).equalsIgnoreCase(list2.get(i))){
                Assert.fail("First list is not equal to second one!!!");
            }
        }

    }
}
