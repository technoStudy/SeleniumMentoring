package Halit._09_TestNG_xml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class _06_Test3 extends _04_BaseDriver {

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
    public void deleteItem(){

        List<WebElement> ItemListInCart = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        WebElement removeButton = driver.findElement(By.xpath("//button[@class='btn_secondary cart_button']"));

        removeButton.click();

        List<WebElement> afterRemoving = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        Assert.assertTrue(ItemListInCart.size() - 1 == afterRemoving.size());

    }

}
