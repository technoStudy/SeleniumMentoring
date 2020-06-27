package Sena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1 {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/RefiaSena/Downloads/chromedriverV83");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/RefiaSena/Documents/SeleniumMentoring/src/Sena/M1_Dropdowns/ref/SignUpFormDropdowns.html");

    }
}
