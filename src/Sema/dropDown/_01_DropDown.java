package Sema.dropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class _01_DropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDependency\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        driver.manage().window().maximize();
        //-->Task1 Find Dropdown
        WebElement justAnInputBox = driver.findElement(By.id("justAnInputBox"));
        justAnInputBox.click();
        //-->Task2 Find Dropdown Elements
        List<WebElement> dropList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
//        //-->Task3 printout DropDown Elements number
       System.out.println(dropList.size());
//        //-->Task4 choose all dropdown elements and printout dropdown elements name
       for(int i =0; i<dropList.size(); i++) {
            String text = dropList.get(i).getText();
            System.out.println(text);

           // Ignore empty values
           if(!text.isEmpty()){
                dropList.get(i).click();
            }

//            //-->Task5 check until choise 6
//            if(text.equals("choice 6")){
//                dropList.get(i).click();
//                break;
//            }



        }
       driver.quit();
    }}

