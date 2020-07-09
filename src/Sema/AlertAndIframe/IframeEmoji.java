package Sema.AlertAndIframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class IframeEmoji{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDependency\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //go to web site
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //maximize the web site
        driver.manage().window().maximize();
//        int size=driver.findElements(By.tagName("iframe")).size();
//        System.out.println(size);
        //
        WebElement iframe = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iframe);
        //click on second emoji
        driver.findElement(By.cssSelector("div[class='mdl-tabs__tab-bar']>a:nth-child(2)")).click();

        //click all second emoji's element
        List<WebElement> natureList = driver.findElements(By.cssSelector("div[class='mdl-tabs__panel is-active']>div>img"));
        for (int i = 0; i < natureList.size(); i++) {
            natureList.get(i).click();
        }
        //go back parent iframe
        driver.switchTo().parentFrame();
        //fill out the form
        driver.findElement(By.cssSelector("div[data-upgraded=',MaterialTextfield']>input[id='text']")).sendKeys("MyEmojies");
        driver.findElement(By.id("smiles")).sendKeys("smiles");
        driver.findElement(By.id("nature")).sendKeys("nature");
        driver.findElement(By.id("food")).sendKeys("food");
        driver.findElement(By.id("activities")).sendKeys("activities");
        driver.findElement(By.id("places")).sendKeys("places");
        driver.findElement(By.id("objects")).sendKeys("objects");
        driver.findElement(By.id("symbols")).sendKeys("symbols");
        driver.findElement(By.id("flags")).sendKeys("flags");
        //click on apply button
        driver.findElement(By.id("send")).click();


       driver.quit();
    }
}
