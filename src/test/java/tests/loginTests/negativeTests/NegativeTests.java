package tests.loginTests.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
    @Test(testName = "Validate scenario with locked_out_user")
    public void loginWithLockedUser(){
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("locked_out_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.close();
        driver.quit();
    }

    @Test(testName = "Validate scenario with username correct + password incorrect")
    public void loginWithCorrectUserIncorrectPass(){
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("not_secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.close();
        driver.quit();
    }

    @Test(testName = "Validate scenario with username incorrect + password correct")
    public void loginWithIncorrectUserCorrectPass(){
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("incorrect_user_name");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.close();
        driver.quit();
    }

    @Test(testName = "Validate scenario with username incorrect + password incorrect")
    public void loginWithIncorrectUserIncorrectPass(){
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("incorrect_user_name");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("not_secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.close();
        driver.quit();
    }

    @Test(testName = "Validate scenario with username empty + password correct")
    public void loginWithEmptyUserCorrectPass(){
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.close();
        driver.quit();
    }

    @Test(testName = "Validate scenario with username correct + password empty")
    public void loginWithCorrectUserEmptyPass(){
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.close();
        driver.quit();
    }

    @Test(testName = "Validate scenario with username empty + password empty")
    public void loginWithEmptyUserEmptyPass(){
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.close();
        driver.quit();
    }
}
