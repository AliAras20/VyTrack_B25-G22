package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class US_11 extends TestBase {

    @Test(dataProvider = "Manager Credentials")
    public void testAC1(String username){

        Driver.getDriver().manage().window().maximize();

        logIn(Driver.getDriver(), username, ConfigurationReader.getProperty("password"));

        Driver.getDriver().navigate().refresh();

        Actions action = new Actions(Driver.getDriver());

        sleep(2);

        action.moveToElement(Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]")))
                .pause(1000).click(Driver.getDriver().findElement(By.xpath("//a/span[.='Vehicle Odometer']"))).perform();

        sleep(1);

        assertEquals(Driver.getDriver().findElement(By.xpath("//div[@class='message']")).getText(), "You do not have permission to perform this action.");
    }


    @Test(dataProvider = "User Credentials")
    public void testAC2(String username){

        Driver.getDriver().manage().window().maximize();

        logIn(Driver.getDriver(), username, ConfigurationReader.getProperty("password"));

        Actions action = new Actions(Driver.getDriver());

        sleep(1);

        action.moveToElement(Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[1]")))
                        .pause(1000).click(Driver.getDriver().findElement(By.xpath("//a/span[.='Vehicle Odometer']"))).perform();

        sleep(1);

        assertEquals(Driver.getDriver().findElement(By.xpath("//ul[@class='icons-holder']/li[2]/input")).getAttribute("value"), "1");
    }


    @Test(dataProvider = "User Credentials")
    public void testAC3(String username){

        Driver.getDriver().manage().window().maximize();

        logIn(Driver.getDriver(), username, ConfigurationReader.getProperty("password"));

        Actions action = new Actions(Driver.getDriver());

        sleep(1);

        action.moveToElement(Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[1]")))
                .pause(1000).click(Driver.getDriver().findElement(By.xpath("//a/span[.='Vehicle Odometer']"))).perform();

        sleep(1);

        assertEquals(Driver.getDriver().findElement(By.xpath("//div[@class='btn-group']/button")).getText(), "25");
    }


    public static void logIn(WebDriver driver, String username, String password){

        driver.get(ConfigurationReader.getProperty("env1"));

        driver.findElement(By.id("prependedInput")).sendKeys(username);

        driver.findElement(By.id("prependedInput2")).sendKeys(password);

        driver.findElement(By.xpath("//button[@id='_submit']")).click();

    }
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }
    @DataProvider(name = "User Credentials")
    public static Object[][] provideDataUC() {
        return new Object[][]{
                {"user160"},
                {"user161"}
        };
    }
    @DataProvider(name = "Manager Credentials")
    public static Object[][] provideDataMC() {
        return new Object[][]{
                {"storemanager80"},
                {"salesmanager137"}
        };
    }
}

/*
Story11:  As a user, I want to view car odometer info on the Vehicles Odometers page.

AC1: Store and Sales managers should see an error message “You do not have permission to perform this action.”
when they click the “Vehicle Odometer” module.

AC2: Drivers should see the default page as 1.
AC3: Divers should see the View Per Page is 25 by default.
 */




    

