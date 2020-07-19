package Sema;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseDriver {
    private String email;
    private String password;
    private String searchWord;
    private String newSearchWord;
    @BeforeClass
    void goToWebsite() {
        email = "test12345asd@test.com";
        password = "qwerty12345";
        searchWord="TechnoStudy";
        newSearchWord="Sema";
        driver.get("https://www.godaddy.com/partners/domain-investors");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    void loginTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
              //tray open
        driver.findElement(By.cssSelector("a[class='tray-toggle']")).click();
//        WebDriverWait wait = new WebDriverWait(driver, 1);
//       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[data-track-name='sign_in_link']"))));
        //sign in button
       driver.findElement(By.cssSelector("a[data-track-name='sign_in_link']")).click();
        //user name
        driver.findElement(By.id("username")).sendKeys(email);
//        //password
       driver.findElement(By.id("password")).sendKeys(password);
//        //submit
       driver.findElement(By.id("submitBtn")).click();
//        //verify that you are submit

       String title = driver.getTitle();
        System.out.println(title);
       Assert.assertEquals(title, "Sign In");
    }

    @Test(priority = 2)
    void searchDomain() throws InterruptedException {
        //send search keys
        driver.findElement(By.id("search-box")).sendKeys(searchWord);
        //click search button
        driver.findElement(By.cssSelector("span[class='input-group-btn']")).click();
        //verify domain name is available
        String text = driver.findElement(By.cssSelector("span[data-cy='tld-domain-only']")).getText();
        String fullText=text.concat(" is available");
        String fullSearchWord=searchWord.toLowerCase().concat(".com is available");
        Assert.assertEquals(fullText,fullSearchWord);
    }

    @Test(priority = 3)
    void addedToCart(){
        driver.findElement(By.cssSelector("button[class='btn btn-primary btn-filled ds-intl']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".js-focus-visible"), 0));

        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals("https://www.godaddy.com/domainsearch/find?checkAvail=1&domainToCheck=TechnoStudy&itc=mya_dom_srch&pl_id=1",driver.getCurrentUrl());
    }

    @Test(priority = 4)
    void searchNewDomain(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //goto main menu
        driver.findElement(By.id("Sales:FeaturedNav:Domains")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[aria-label='Type the one you want here']")));
       //send search keys
         driver.findElement(By.cssSelector("input[aria-label='Type the one you want here']")).sendKeys(newSearchWord);
      //click search button
        driver.findElement(By.cssSelector("span[class='input-group-btn']")).click();
        //verify domain name is available
        String text = driver.findElement(By.cssSelector("span[data-cy='tld-domain-only']")).getText();
         //  System.out.println(text);
       String fullText=text.concat(" is taken");
      String fullSearchWord=newSearchWord.toLowerCase().concat(".com is taken");
       Assert.assertEquals(fullText,fullSearchWord);
    }



    }


