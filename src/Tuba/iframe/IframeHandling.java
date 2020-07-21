package Tuba.iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/guru99home/");
        // with the id
       // driver.switchTo().frame("a077aa5e");

        // with the index

       //

        int size=driver.findElements(By.tagName("iframe")).size();
       // System.out.println(size);

        for (int i = 0; i <size ; i++) {
            driver.switchTo().frame(i);
            int myFrame=driver.findElements(By.xpath("//html/body/a/img")).size();
            System.out.println(myFrame);
            driver.switchTo().defaultContent();

        }

        // switch with index
//        driver.switchTo().frame(1);
//        driver.findElement(By.xpath("html/body/a/img")).click();


    }
}
