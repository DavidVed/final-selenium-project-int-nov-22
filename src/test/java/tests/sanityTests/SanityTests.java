package tests.sanityTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SanityTests {
    @Test
    public void sanityTest(){
        WebDriver driver = new ChromeDriver();

//Validate login page URL
        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, baseUrl, "The URL is different.");

//Validate login with the user standard_user
        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

//Validate inventory page URL
        String productsPageUrl = "https://www.saucedemo.com/inventory.html";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, productsPageUrl, "The URL is different.");

//Validate inventory page title
        String title = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedTitle = "Products";
        Assert.assertEquals(title, expectedTitle, "The title is different.");

//Choosing two products
        driver.findElement(By.cssSelector("[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.cssSelector("[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();

//Validate the cart icon presents a correct number of items (2)
        WebElement shoppingCartBadge = driver.findElement(By.cssSelector("[class=\"shopping_cart_badge\"]"));
        int actualNumberOfItems = Integer.parseInt(shoppingCartBadge.getText());
        int expectedNumberOfItems = 2;
        Assert.assertEquals(actualNumberOfItems, expectedNumberOfItems, "Number of items is different.");

//Click on shopping cart icon
        shoppingCartBadge.click();

//Validate shopping cart page URL
        String cartPageUrl = "https://www.saucedemo.com/cart.html";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, cartPageUrl, "The URL is different.");

//Validate shopping cart page title
        String actualCartPageTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedCartPageTitle = "Your Cart";
        Assert.assertEquals(actualCartPageTitle, expectedCartPageTitle, "The title is different.");

//Validate a correct number of items (2)
        Assert.assertEquals(actualNumberOfItems, expectedNumberOfItems, "Number of items is different.");

//Click on checkout button
        driver.findElement(By.cssSelector("[data-test=\"checkout\"]")).click();

//Validate checkout step one page URL
        String checkoutPageUrl = "https://www.saucedemo.com/checkout-step-one.html";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, checkoutPageUrl, "The URL is different.");

//Validate checkout step one page title
        String actualCheckoutPageTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedCheckoutPageTitle = "Checkout: Your Information";
        Assert.assertEquals(actualCheckoutPageTitle, expectedCheckoutPageTitle, "The title is different.");

//Fill the checkout form
        driver.findElement(By.id("first-name")).sendKeys("David");
        driver.findElement(By.id("last-name")).sendKeys("Vedeshin");
        driver.findElement(By.id("postal-code")).sendKeys("2641813");

//Click on continue button
        driver.findElement(By.cssSelector("[data-test=\"continue\"]")).click();

//Validate checkout step two page URL
        String checkoutPageUrl2 = "https://www.saucedemo.com/checkout-step-two.html";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, checkoutPageUrl2, "The URL is different.");

//Validate checkout step two page title
        String actualCheckoutPageTitle2 = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedCheckoutPageTitle2 = "Checkout: Overview";
        Assert.assertEquals(actualCheckoutPageTitle2, expectedCheckoutPageTitle2, "The title is different.");

//Click on finish button
        driver.findElement(By.cssSelector("[data-test=\"finish\"]")).click();

//Validate complete page URL
        String completePageUrl = "https://www.saucedemo.com/checkout-complete.html";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, completePageUrl, "The URL is different.");

//Validate complete page title
        String actualCompletePageTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedCompletePageTitle = "Checkout: Complete!";
        Assert.assertEquals(actualCompletePageTitle, expectedCompletePageTitle, "The title is different.");

//Validate a text of each one of the presented messages
        String completeHeader = driver.findElement(By.cssSelector("[class=\"complete-header\"]")).getText();
        String expectedHeader = "Thank you for your order!";
        Assert.assertEquals(completeHeader, expectedHeader, "The title is different.");

        String completeText = driver.findElement(By.cssSelector("[class=\"complete-text\"]")).getText();
        String expectedText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        Assert.assertEquals(completeText, expectedText, "The title is different.");

//Close and quit
        driver.close();
        driver.quit();
    }
}