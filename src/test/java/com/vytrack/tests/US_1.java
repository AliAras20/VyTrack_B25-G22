package com.vytrack.tests;


/* 1. login as a salesmanager or storemanagers
   2. Verify the users see 8 modules: Dashboards, Fleet,
      Customers, Sales, Activities, Marketing, Reports & Segments,
      System
   3. login as a driver
   4. Verify the users see 4 modules: Fleet, Customers,
      Activities, System

 */

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_1 extends TestBase {

    @Test
    public void verifying_modules_as_sales_manager() {
        VyTrackUtils.loginAsSalesManager();
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));


        List<String> actualModuleTexts = new ArrayList<>();

        for (WebElement each : moduleElements) {
            String moduleElementText = each.getText();
            actualModuleTexts.add(moduleElementText);
        }

        List<String> expectedModuleTexts = new ArrayList<>(Arrays.asList("Dashboards", "Fleet",
                "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"));
        Assert.assertEquals(actualModuleTexts, expectedModuleTexts, "Test is failed!");
    }

    @Test
    public void verifying_modules_as_sales_storemanager() {
        VyTrackUtils.loginAsStoreManger();
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));


        List<String> actualModuleTexts = new ArrayList<>();

        for (WebElement each : moduleElements) {
            String moduleElementText = each.getText();
            actualModuleTexts.add(moduleElementText);
        }

        List<String> expectedModuleTexts = new ArrayList<>(Arrays.asList("Dashboards", "Fleet",
                "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"));
        Assert.assertEquals(actualModuleTexts, expectedModuleTexts, "Test is failed!");
    }

    @Test
    public void verifying_modules_as_driver() {
        VyTrackUtils.loginAsDriver();
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));

        List<String> actualModuleTexts = new ArrayList<>();

        moduleElements.forEach(webElement -> actualModuleTexts.add(webElement.getText()));


        List<String> expectdModuleTexts = new ArrayList<>(Arrays.asList("Fleet", "Customers", "Activities", "System"));
        Assert.assertEquals(actualModuleTexts, expectdModuleTexts, "Test is failed");

    }
}
