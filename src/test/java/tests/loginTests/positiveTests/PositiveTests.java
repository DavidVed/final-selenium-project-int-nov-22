package tests.loginTests.positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
    @Test(testName = "Validate scenario with standard_user")
    public void loginWithStandardUser(){
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, baseUrl, "The URL is different.");

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String productsPageUrl = "https://www.saucedemo.com/inventory.html";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, productsPageUrl, "The URL is different.");

        String title = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedTitle = "Products";
        Assert.assertEquals(title, expectedTitle, "The title is different.");

        driver.close();
        driver.quit();
    }

    @Test(testName = "Validate scenario with problem_user")
    public void loginWithProblem_user(){
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, baseUrl, "The URL is different.");

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("problem_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String productsPageUrl = "https://www.saucedemo.com/inventory.html";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, productsPageUrl, "The URL is different.");

        String title = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedTitle = "Products";
        Assert.assertEquals(title, expectedTitle, "The title is different.");

        driver.close();
        driver.quit();
    }

    @Test(testName = "Validate scenario with performance_glitch_user")
    public void loginWithPerformance_glitch_user() {
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, baseUrl, "The URL is different.");

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("performance_glitch_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String productsPageUrl = "https://www.saucedemo.com/inventory.html";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, productsPageUrl, "The URL is different.");

        String title = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedTitle = "Products";
        Assert.assertEquals(title, expectedTitle, "The title is different.");

        driver.close();
        driver.quit();
    }

    @Test(testName = "Validate scenario with error_user")
    public void loginWithError_user() {
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, baseUrl, "The URL is different.");

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("error_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String productsPageUrl = "https://www.saucedemo.com/inventory.html";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, productsPageUrl, "The URL is different.");

        String title = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedTitle = "Products";
        Assert.assertEquals(title, expectedTitle, "The title is different.");

        driver.close();
        driver.quit();
    }

    @Test(testName = "Validate scenario with visual_user")
    public void loginWithVisual_user() {
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, baseUrl, "The URL is different.");

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("visual_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String productsPageUrl = "https://www.saucedemo.com/inventory.html";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, productsPageUrl, "The URL is different.");

        String title = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedTitle = "Products";
        Assert.assertEquals(title, expectedTitle, "The title is different.");

        driver.close();
        driver.quit();
    }
}