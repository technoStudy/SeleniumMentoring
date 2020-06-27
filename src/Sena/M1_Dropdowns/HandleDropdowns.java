package Sena.M1_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropdowns {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/RefiaSena/Downloads/chromedriverV83");
        WebDriver driver = new ChromeDriver();
//        driver.get("file:///Users/RefiaSena/Documents/SeleniumMentoring/src/Sena/M1_Dropdowns/ref/SignUpForm.html");
        driver.get("file:///Users/RefiaSena/Documents/SeleniumMentoring/src/Sena/M1_Dropdowns/ref/SignUpFormDropdowns.html");

        // Visualize a website that you create an account at.
        // We already know how to handle inputs like name, last name, address etc with selenium to automate.
        // but how about dropdown fields like gender, country, age???

        /** I.Q.: How do we handle dropdowns in Selenium?
            Answer: We use SELECT CLASS to handle dropdowns in selenium **/

        // after you locate a dropdown with WebElement, you can select the option you'd like by:
        // 1. Selecting by index!
        // 2. Selecting by value!
        // 3. Selecting by visible text!

        // here is an example :)

//        WebElement exDropdown = driver.findElement(By.xpath("")); // found the dropdown
//
//        Select select = new Select(exDropdown); // created Select class to be able to select options within the dropdown
//
//        select.selectByIndex(0); // selected an option
//        select.selectByValue("");
//        select.selectByVisibleText("");



        /** TASKS:
         *
         * We have 4 dropdowns on this website: Country, Age, Plan, and Contact Preference
         *
         * 1: Create WebElements for all dropdowns
         *
         */

        WebElement countryD = driver.findElement(By.name("country"));
        WebElement ageD = driver.findElement(By.xpath("//p[@name='ageSelP']//select"));
        WebElement planD = driver.findElement(By.xpath("//select[@name='plan']"));
        WebElement contactPD = driver.findElement(By.xpath("//p[@name='contactP']//select"));

        /**
         * 2: Select Peru as Country by text
         */

        Select country = new Select(countryD);
        country.selectByVisibleText("Peru");

        /**
         * 3: Select your age range by index
         */

        Select ageS = new Select(ageD);
        ageS.selectByIndex(4);

        /**
         * 4: Select Enterprise as Plan by value
         */

        Select planS = new Select(planD);
        planS.selectByValue("e");

        /**
         * 5: Select all values sequentially for Contact Preference by any selection option you'd like
         * tip: loops? :))
         */

        Select contactSelect = new Select(contactPD);

        // 1st way:

        contactSelect.selectByIndex(0);
        contactSelect.selectByIndex(1);

        // 2nd way:

        int numOfOptionsForcontact = contactSelect.getOptions().size();
        for (int i = 0; i < numOfOptionsForcontact; i++) {
            contactSelect.selectByIndex(i);
        }

        // 3rd way :) ? :

        List<WebElement> contacts = contactSelect.getOptions();
        for (WebElement contact : contacts) {
            System.out.println(contact.getText());
        }


        /**
         * Extra practice:
         * use -> driver.get("file:///Users/RefiaSena/Documents/SeleniumMentoring/src/Sena/M1_Dropdowns/ref/SignUpForm.html");
         * Complete the form and click on Submit
         *
         * tip: you might need to scroll into view since not all objs are shown in the screen,
         * please use the method "scrollInto" created for you (find it below)
         * just provide (driver, element)
         * if the dropdown is named as ageDropdown then write that instead of element
         */


    }

    public static void scrollInto (WebDriver driver, WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }
}
