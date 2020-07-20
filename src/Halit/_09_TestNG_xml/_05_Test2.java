package Halit._09_TestNG_xml;

import Halit._08_TestNG_IgnorePriority._01_BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class _05_Test2 extends _01_BaseDriver {

    @Test(priority = 1)
    public void addToCart(){

        List<WebElement> itemList = driver.findElements(By.xpath("//button[@class='btn_primary btn_inventory']"));

        List<WebElement> itemNameList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        Random rnd = new Random();

        int a = rnd.nextInt(itemList.size());

        String addedItem = itemNameList.get(a).getText();

        itemList.get(a).click();

        WebElement cartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']"));

        cartButton.click();

        WebElement itemInTheCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

        String itemNameInTheCart = itemInTheCart.getText();

        Assert.assertEquals(addedItem,itemNameInTheCart);

    }

    @Test(priority = 2)
    public void proceedToCheckout(){

        WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));

        checkoutButton.click();

        WebElement firstName = driver.findElement(By.id("first-name"));

        firstName.sendKeys("Andres");

        WebElement lastName = driver.findElement(By.id("last-name"));

        lastName.sendKeys("Iniesta");

        WebElement zipCode = driver.findElement(By.id("postal-code"));

        zipCode.sendKeys("02134");

        WebElement continueButton = driver.findElement(By.xpath("//input[@class='btn_primary cart_button']"));

        continueButton.click();

        WebElement finishButton = driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));

        finishButton.click();

        WebElement finishMessage = driver.findElement(By.xpath("//h2[@class='complete-header']"));

        String finishMessageStr = finishMessage.getText();

        Assert.assertEquals(finishMessageStr,"THANK YOU FOR YOUR ORDER");

    }



}
