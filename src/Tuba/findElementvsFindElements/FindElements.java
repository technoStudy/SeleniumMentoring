package Tuba.findElementvsFindElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class FindElements {
    public static void main(String[] args) {
        /*
        FindElement                                          vs                    FindElements

        -Returns the first most web element if there are multiple             find a list of  WebELements
        web elements found with the same locator

        -return only one element

        - gives NoSuchElementException                                        -gives an empty list
         */


        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://formsmarts.com/form/yu?mode=h5");
        // Example of an element
//        WebElement businessRadioButton = driver.findElement(By.id("u_iPi_4586_0"));
//        businessRadioButton.click();

        // example of a list

//        List<WebElement> xyz = driver.findElements(By.xpath("//fieldset[@id='u_iPi_89585']//label"));
//        System.out.println(xyz.size());


        // Task

              /*
        TASK1
        Print the all options of "How Did you discover XYZ?"
        output will be
        Select an option:
        Search Engine
        Referred by Existing Customer
        Online Advertising
        Offline Advertising
        Other
         */

//        List<WebElement> lists = driver.findElements(By.cssSelector("#u_iPi_4588>option"));
//        for (WebElement list:lists) {
//            System.out.println(list.getText());
//        }
//    }

        WebElement select = driver.findElement(By.xpath("//select"));

        Select select1 = new Select(select);

        List<WebElement> option = select1.getOptions();

        for (int i = 0; i < option.size(); i++) {
            System.out.println(option.get(i).getText());
        }
    }
    }



