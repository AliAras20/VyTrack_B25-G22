package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_5 extends TestBase {

    @Test
    public void verify_modules_saleManager() throws InterruptedException {

        VyTrackUtils.loginAsSalesManager();
        Thread.sleep(1000);
        WebElement fleetDropdown = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        Actions action = new Actions (Driver.getDriver());

        action.moveToElement(fleetDropdown).click().perform();

        Thread.sleep(1000);
        WebElement vehicleModelBtn = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        action.moveToElement(vehicleModelBtn).click().perform();

        Thread.sleep(3000);
        List<WebElement> actualModules = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//span[@class='grid-header-cell__label']"));
        List<String> actualModulesText = new ArrayList<>();

        for (WebElement eachModule : actualModules) {
            String eachModuleText = eachModule.getText();
            //  System.out.println(eachModuleText);
            actualModulesText.add(eachModuleText);

        }
        //System.out.println("actualModulesText = " + actualModulesText);
        List<String>expectedModulesText = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED", "CVVI", "CO2 FEE (/MONTH)", "COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS", "FUEL TYPE", "VENDORS"));

        Assert.assertEquals(actualModulesText,expectedModulesText);

    }
    @Test
    public void verify_modules_storeManager() throws InterruptedException {

        VyTrackUtils.loginAsStoreManger();
        Thread.sleep(1000);
        WebElement fleetDropdown =Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
        Actions action = new Actions (Driver.getDriver());

        action.moveToElement(fleetDropdown).click().perform();

        Thread.sleep(1000);
        WebElement vehicleModelBtn = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        action.moveToElement(vehicleModelBtn).click().perform();

        Thread.sleep(3000);
        List<WebElement>actualModules = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//span[@class='grid-header-cell__label']"));
        List<String> actualModulesText = new ArrayList<>();

        for (WebElement eachModule : actualModules) {
            String eachModuleText = eachModule.getText();
            //  System.out.println(eachModuleText);
            actualModulesText.add(eachModuleText);

        }
        //System.out.println("actualModulesText = " + actualModulesText);
        List<String>expectedModulesText = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED", "CVVI", "CO2 FEE (/MONTH)", "COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS", "FUEL TYPE", "VENDORS"));

        Assert.assertEquals(actualModulesText,expectedModulesText);

    }

    @Test
    public void verify_modules_driver() throws InterruptedException {

        VyTrackUtils.loginAsDriver();
        Thread.sleep(1000);
        WebElement fleetDropdown =Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[1]"));
        Actions action = new Actions (Driver.getDriver());

        action.moveToElement(fleetDropdown).click().perform();

        Thread.sleep(1000);

        WebElement vehicleModelBtn = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        action.moveToElement(vehicleModelBtn).click().perform();

        Thread.sleep(1000);
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("(//div[@class='message'])[2]"));

        String actualErrorMessageText= errorMessage.getText();
        String expectedMessageText = "You do not have permission to perform this action.";

        Assert.assertEquals(actualErrorMessageText,expectedMessageText);


    }
}


