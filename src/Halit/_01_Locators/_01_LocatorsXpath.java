//package Halit._01_Locators;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class _01_LocatorsXpath {
//
//    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halit\\Documents\\Selenium\\chromedriver\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//
//        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
//
//        WebElement addToCart1 = driver.findElement(By.xpath("(//span[text()='Add to Cart'])[1]"));
//        addToCart1.click();
//
//        Thread.sleep(2000);
//
//        WebElement addToCart2 = driver.findElement(By.xpath("(//span[text()='Add to Cart'])[2]"));
//        addToCart2.click();
//
//        Thread.sleep(2000);
//
//        WebElement goToCart = driver.findElement(By.xpath("//span[text()='Shopping Cart']"));
//        goToCart.click();
//
////        How to make sure firstPrice + secondPrice = total
//
//        WebElement firstItemPrice = driver.findElement(By.xpath("(//td[text()='$123.20'])[3]"));
//        String firstPrice = firstItemPrice.getText();
//
//        WebElement secondItemPrice = driver.findElement(By.xpath("(//td[text()='$602.00'])[3]"));
//        String secondPrice = secondItemPrice.getText();
//
//        WebElement totalPrice = driver.findElement(By.xpath("(//td[text()='$725.20'])[2]"));
//        String total = totalPrice.getText();
//
//
//        double price1Double = changeStringToDouble(firstPrice);
//        double price2Double = changeStringToDouble(secondPrice);
//        double totalDouble = changeStringToDouble(total);
//
//        Assert.assertTrue(price1Double + price2Double == totalDouble);
//
//        WebElement checkout = driver.findElement(By.xpath("(//a[@href='http://tutorialsninja.com/demo/index.php?route=checkout/checkout'])[3]"));
//        checkout.click();
//
//        Thread.sleep(2000);
//
//        WebElement continueCheckout = driver.findElement(By.xpath("//input[@id='button-account']"));
//        continueCheckout.click();
//
//        Thread.sleep(2000);
//
//        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
//        firstName.sendKeys("Halit");
//
//        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
//        lastName.sendKeys("Kocaaga");
//
//        WebElement email = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
//        email.sendKeys("halita2212k@gmail.com");
//
//        WebElement telephone = driver.findElement(By.xpath("//input[@name='telephone']"));
//        telephone.sendKeys("123456789");
//
//        WebElement address = driver.findElement(By.xpath("//input[@name='address_1']"));
//        address.sendKeys("600 Getty Ave.");
//
//        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
//        city.sendKeys("Clifton");
//
//        WebElement PostCode = driver.findElement(By.xpath("//input[@name='postcode']"));
//        PostCode.sendKeys("07011");
//
//        WebElement country = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
//        country.click();
//
//        WebElement selectCountry = driver.findElement(By.xpath("//option[text()='United States']"));
//        selectCountry.click();
//
//        WebElement state = driver.findElement(By.xpath("//select[@name='zone_id']"));
//        state.click();
//
//        Thread.sleep(2000);
//
//        WebElement selectState = driver.findElement(By.xpath("//option[text()='New Jersey']"));
//        selectState.click();
//
//        Thread.sleep(2000);
//
//        WebElement password = driver.findElement(By.xpath("//input[@id='input-payment-password']"));
//        password.sendKeys("123456789");
//
//        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-payment-confirm']"));
//        passwordConfirm.sendKeys("123456789");
//
//        WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
//        checkbox.click();
//
//        WebElement continue2 = driver.findElement(By.xpath("//input[@id='button-register']"));
//        continue2.click();
//
//        Thread.sleep(2000);
//
//        WebElement continue3 = driver.findElement(By.xpath("//input[@id='button-shipping-address']"));
//        continue3.click();
//
//        Thread.sleep(2000);
//
//        WebElement continue4 = driver.findElement(By.xpath("//input[@id='button-shipping-method']"));
//        continue4.click();
//
//        Thread.sleep(2000);
//
//        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='agree']"));
//        checkbox2.click();
//
//        WebElement continue5 = driver.findElement(By.xpath("//input[@id='button-payment-method']"));
//        continue5.click();
//
//        Thread.sleep(2000);
//
//        WebElement confirmOrder = driver.findElement(By.xpath("//input[@value='Confirm Order']"));
//        confirmOrder.click();
//
//        Thread.sleep(2000);
//
//        WebElement finish = driver.findElement(By.xpath("//a[text()='Continue']"));
//        finish.click();
//
//        driver.quit();
//
//
//
//
//
//
//
//    }
//
//    /*
//
//        I need a method which has taking a string
//        And remove all the non numeric characters and change the String to double
//        And give me double
//
//     */
//
//    public static double changeStringToDouble(String myString){
//
//        myString = myString.replaceAll("[^\\d.]",""); // remove all the non numeric char (letter or special character)
//
//        double myD = Double.parseDouble(myString);
//
//        return myD;
//
//    }
//
//
//}
//
//
