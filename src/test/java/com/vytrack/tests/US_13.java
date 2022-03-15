package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
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

public class US_13 extends TestBase {

    @Test(priority = 1)
    public void verifying_3_columns_As_StoreManager(){

        //User is able Log in as driver or as store or sales managers
        VyTrackUtils.loginAsStoreManger();
        BrowserUtils.sleep(5);

        //User successfully logs in, expected page title is "Dashboard".
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle,expectedTitle);


        //User is able to click the "Vehicle Costs" under the "Fleet"
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
        WebElement vehicleCostsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehicleCosts']/span"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(fleetButton).pause(1000).click().perform();
        action.moveToElement(vehicleCostsButton).pause(1000).click().perform();

        BrowserUtils.sleep(2);

        //User is able to verify there are 3 columns on the table: TYPE, TOTAL PRICE, DATE
        List<WebElement> actualColumnNames = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//th//span[1]"));
        List<String> actualColumnText = new ArrayList<>();
        List<String> expectedColumnsText = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));


        for (WebElement each : actualColumnNames) {
            String eachText = each.getText();
            actualColumnText.add(eachText);
        }
        System.out.println(actualColumnText);

        Assert.assertEquals(actualColumnText,expectedColumnsText);

    }
    @Test(priority = 2)
    public void verifying_3_columns_As_SalesManager(){
        //User is able Log in as driver or as store or sales managers
        VyTrackUtils.loginAsSalesManager();
        BrowserUtils.sleep(5);

        //User successfully logs in, expected page title is "Dashboard".
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle,expectedTitle);


        //User is able to click the "Vehicle Costs" under the "Fleet"
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
        WebElement vehicleCostsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehicleCosts']/span"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(fleetButton).pause(1000).click().perform();
        action.moveToElement(vehicleCostsButton).pause(1000).click().perform();

        BrowserUtils.sleep(2);

        //User is able to verify there are 3 columns on the table: TYPE, TOTAL PRICE, DATE
        List<WebElement> actualColumnNames = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//th//span[1]"));
        List<String> actualColumnText = new ArrayList<>();
        List<String> expectedColumnsText = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));


        for (WebElement each : actualColumnNames) {
            String eachText = each.getText();
            actualColumnText.add(eachText);
        }
        System.out.println(actualColumnText);

        Assert.assertEquals(actualColumnText,expectedColumnsText);
    }

    @Test(priority = 3)
    public void verifying_3_columns_As_Driver(){

        //User is able Log in as driver or as store or sales managers
        VyTrackUtils.loginAsDriver();
        BrowserUtils.sleep(5);

        //User successfully logs in, expected page title is "Dashboard".
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle,expectedTitle);


        //User is able to click the "Vehicle Costs" under the "Fleet"
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[1]"));
        WebElement vehicleCostsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehicleCosts']/span"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(fleetButton).pause(1000).click().perform();
        action.moveToElement(vehicleCostsButton).pause(1000).click().perform();

        BrowserUtils.sleep(2);

        //User is able to verify there are 3 columns on the table: TYPE, TOTAL PRICE, DATE
        List<WebElement> actualColumnNames = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//th//span[1]"));
        List<String> actualColumnText = new ArrayList<>();
        List<String> expectedColumnsText = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));


        for (WebElement each : actualColumnNames) {
            String eachText = each.getText();
            actualColumnText.add(eachText);
        }
        System.out.println(actualColumnText);

        Assert.assertEquals(actualColumnText,expectedColumnsText);

    }

    @Test(priority = 4)
    public void user_as_StoreManager_check_first_checkBox() {

        //User is able Log in as driver or as store or sales managers
        VyTrackUtils.loginAsStoreManger();
        BrowserUtils.sleep(5);

        //User successfully logs in, expected page title is "Dashboard".
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle);


        //User is able to click the "Vehicle Costs" under the "Fleet"
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
        WebElement vehicleCostsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehicleCosts']/span"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(fleetButton).pause(1000).click().perform();
        action.moveToElement(vehicleCostsButton).pause(1000).click().perform();

        BrowserUtils.sleep(2);

        WebElement typeCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']//input[@type='checkbox']"));
        typeCheckBox.click();

        boolean isSelectedType = typeCheckBox.isSelected();
        System.out.println("isSelectedType = " + isSelectedType);

        List<WebElement> allTypeCheckBoxes = Driver.getDriver().findElements(By.xpath("//input[@tabindex='-1']"));


        for (WebElement eachOfCheckB : allTypeCheckBoxes) {
            boolean isSelEach = eachOfCheckB.isSelected();
            Assert.assertTrue(isSelEach);
        }


    }

    @Test(priority = 5)
    public void user_as_SalesManager_check_first_checkBox() {

        //User is able Log in as driver or as store or sales managers
        VyTrackUtils.loginAsSalesManager();
        BrowserUtils.sleep(5);

        //User successfully logs in, expected page title is "Dashboard".
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle);


        //User is able to click the "Vehicle Costs" under the "Fleet"
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
        WebElement vehicleCostsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehicleCosts']/span"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(fleetButton).pause(1000).click().perform();
        action.moveToElement(vehicleCostsButton).pause(1000).click().perform();

        BrowserUtils.sleep(2);

        WebElement typeCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']//input[@type='checkbox']"));
        typeCheckBox.click();

        boolean isSelectedType = typeCheckBox.isSelected();
        System.out.println("isSelectedType = " + isSelectedType);

        List<WebElement> allTypeCheckBoxes = Driver.getDriver().findElements(By.xpath("//input[@tabindex='-1']"));


        for (WebElement eachOfCheckB : allTypeCheckBoxes) {
            boolean isSelEach = eachOfCheckB.isSelected();
            Assert.assertTrue(isSelEach);
        }


    }
}
