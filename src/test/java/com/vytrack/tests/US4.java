package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US4 extends TestBase {


    @Test
    public void StoreManager() throws InterruptedException {
        VyTrackUtils.loginAsStoreManger();


        WebElement fleet = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1'][normalize-space()='Fleet']"));
        Thread.sleep(1000);
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(fleet).perform();
       Thread.sleep(1000);


        WebElement vehicleContracts =Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item']//a[@href='/entity/Extend_Entity_VehicleContract']"));
        vehicleContracts.click();


        String actualURL =Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract";
        Assert.assertEquals(expectedURL, actualURL);

        Thread.sleep(1000);

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Test
    public void salesManager() throws InterruptedException {

        VyTrackUtils.loginAsSalesManager();

        WebElement fleet = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1'][normalize-space()='Fleet']"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(fleet).perform();
       Thread.sleep(1000);


        WebElement vehicleContracts = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item']//a[@href='/entity/Extend_Entity_VehicleContract']"));
        vehicleContracts.click();


        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract";
        Assert.assertEquals(expectedURL, actualURL);

      Thread.sleep(1000);

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Test
    public void driverLogIn()throws InterruptedException{

        VyTrackUtils.loginAsDriver();

        WebElement fleet = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1'][normalize-space()='Fleet']"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(fleet).perform();
        Thread.sleep(1000);


        WebElement vehicleContracts = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item']//a[@href='/entity/Extend_Entity_VehicleContract']"));
        vehicleContracts.click();

        Thread.sleep(1000);

        WebElement textNote= Driver.getDriver().findElement(By.xpath("//div[@data-messenger-namespace='eed2dfc230ad3968235b216c8d8c54588cb2f30904a1c179d4416e09dd8008d3']"));

        Assert.assertTrue(textNote.isDisplayed());


    }
}




















