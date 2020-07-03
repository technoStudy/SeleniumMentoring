package Sema.dropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class _02_DropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDependency\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //Select single value with generic method

        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        driver.manage().window().maximize();
        driver.findElement(By.id("justAnInputBox")).click();

        selectSingleValue(driver, "choice 3");
        driver.quit();
    }

    public static void selectSingleValue(WebDriver driver, String value) {

        List<WebElement> dropList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));


        for (int i = 0; i < dropList.size(); i++) {
            String text = dropList.get(i).getText();


            if (!text.isEmpty()) {
                if (text.equals(value)) {
                    dropList.get(i).click();
                    break;
                }
            }
        }
    }
//            try {
//                if(!text.isEmpty()){
//                    if(text.equals(value)){
//                        dropList.get(i).click();
//                        break;
//                    }
//                }
//            } catch (Exception e) {
//            }

}
