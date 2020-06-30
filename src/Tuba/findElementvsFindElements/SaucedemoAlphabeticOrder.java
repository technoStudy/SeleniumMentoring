package Tuba.findElementvsFindElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;

public class SaucedemoAlphabeticOrder {
    public static void main(String[] args) {

        /*
        TASK2
        Select Name (A to Z)
        And verify that the items are ordered by alphabetically

         */
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/inventory.html");

        WebElement element=driver.findElement(By.cssSelector("select[class='product_sort_container']"));

        Select select=new Select(element);
        select.selectByVisibleText("Name (A to Z)");

        List<WebElement> itemNames=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        ArrayList<String> nameList=new ArrayList<>();

        ArrayList<String> nameList2=new ArrayList<>();

        for (WebElement item:itemNames){
            nameList.add(item.getText());
            nameList2.add(item.getText());
        }

        Collections.sort(nameList);

        System.out.println(nameList.equals(nameList2));





        List<WebElement> lists = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> lists2 = new ArrayList<>();

        for (WebElement list:lists) {
            lists2.add(list.getText());
        }
        Collections.sort(lists2);

        for (int i = 0; i <lists.size() ; i++) {

            if (!lists2.get(i).equalsIgnoreCase(lists.get(i).getText())){

                Assert.fail("Lists are not match each other");

            }

        }
    }

    }

