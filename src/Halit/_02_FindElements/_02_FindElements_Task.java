package Halit._02_FindElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _02_FindElements_Task {

    public static void main(String[] args) throws InterruptedException {

        //                            TASK 1
        //Navigate to "https://react-shopping-cart-67954.firebaseapp.com/"
        // List all the elements on the website
        // Create a String Arraylist and put Product Names into the ArrayList
        // Choose 5 items randomly, add to cart and print the names of items
        // (Each product cannot be added more then 1 time!)

        // CHECK THE PRICES!
        // Sum each item's price and compare your result with the website
        // If results are matching print success message
        // Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
        // Click Checkout

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        List<WebElement> allProducts = driver.findElements(By.className("shelf-item__title"));

        List<String> allProductsStringList = new ArrayList<>();

        for (int i = 0; i < allProducts.size(); i++) {
            allProductsStringList.add(allProducts.get(i).getText());
        }

        System.out.println("all products list --> " + allProductsStringList);


        List<Integer> numberOfItemsAddedToCart = new ArrayList<>();

        while (numberOfItemsAddedToCart.size() < 5) {

            Random rnd = new Random();

            int a = rnd.nextInt(allProducts.size());

            if (!numberOfItemsAddedToCart.contains(a)) {

                numberOfItemsAddedToCart.add(a);

                allProducts.get(a).click();

                Thread.sleep(2000);

                System.out.println("Chosen product" + a + " --> " + allProducts.get(a).getText());

                driver.findElement(By.xpath("//div[@class='float-cart__close-btn']")).click();

                Thread.sleep(2000);

            }


        }

        driver.findElement(By.xpath("//span[@class='bag bag--float-cart-closed']")).click(); // if there is a space in class name you cannot use BY.classname

        double total = 0;

        List<WebElement> pricesOfProducts = driver.findElements(By.xpath("//div[@class='float-cart float-cart--open']//div[@class='shelf-item__price']"));

        List<Double>eachPriceDouble = new ArrayList<>();

        for (int k = 0; k < pricesOfProducts.size(); k++) {


            String myString = pricesOfProducts.get(k).getText();

            myString = myString.replaceAll("[^\\d.]", ""); // remove all the non numeric char (letter or special character)

            double myD = Double.parseDouble(myString);

            eachPriceDouble.add(myD);

            total += myD;


        }





    }

}


















