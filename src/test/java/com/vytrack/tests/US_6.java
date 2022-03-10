package com.vytrack.tests;

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
import java.util.concurrent.TimeUnit;

public class US_6 {

   public WebElement findElementByXpath(String xpath){
       return Driver.getDriver().findElement(By.xpath(xpath));
   }

    @Test
    public void US_6_Driver() {

        VyTrackUtils.loginAsDriver();
        WebElement fleet = findElementByXpath("(//span[@class='title title-level-1'])[1]");
        fleet.click();

       WebElement vehicles = findElementByXpath("//span[text()='Vehicles']");
       vehicles.click();

       Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

       WebElement dots = findElementByXpath("//table/tbody/tr[1]/td[@class='action-cell grid-cell grid-body-cell']");
       Actions actions = new Actions(Driver.getDriver());
       actions.moveToElement(dots).pause(1000).click().perform();

       String valuesOfOpenedItems= "//table/tbody/tr[1]/td[@class='action-cell grid-cell grid-body-cell']//li/ul/li/a";

       Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

       List<WebElement> launcherItems = new ArrayList<>(Driver.getDriver().findElements(By.xpath(valuesOfOpenedItems)));

       Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

       List<String> actualTitles = new ArrayList<>();
       for(WebElement each : launcherItems){
            actualTitles.add(each.getAttribute("title"));
        }

       List<String> expectedTitles = new ArrayList<>(Arrays.asList("View" ,"Edit", "Delete"));
       Assert.assertEquals(expectedTitles,actualTitles,"Actual Titles are not matching with the expected ones");

       Driver.closeDriver();
   }

    @Test
    public void US_6_StoreManager(){
       VyTrackUtils.loginAsStoreManger();

        WebElement fleet = findElementByXpath("//li[@class='dropdown dropdown-level-1']/a/span[@class='title title-level-1'and contains(text(),'Fleet')]");
        Actions hoverToFleet = new Actions(Driver.getDriver());
        hoverToFleet.moveToElement(fleet).build().perform();

        WebElement vehicles = findElementByXpath("(//li[@class='dropdown-menu-single-item first'])[2]/a");
        vehicles.click();

        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement dots = findElementByXpath("//table/tbody/tr[1]/td[@class='action-cell grid-cell grid-body-cell']");
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(dots).pause(1000).click().perform();

        String valuesOfOpenedItems= "//table/tbody/tr[1]/td[@class='action-cell grid-cell grid-body-cell']//li/ul/li/a";

        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        List<WebElement> launcherItems = new ArrayList<>(Driver.getDriver().findElements(By.xpath(valuesOfOpenedItems)));

        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        List<String> actualTitles = new ArrayList<>();
        for(WebElement each : launcherItems){
            actualTitles.add(each.getAttribute("title"));
        }
        System.out.println(actualTitles);

        List<String> expectedTitles = new ArrayList<>(Arrays.asList("View" ,"Edit", "Delete"));
        Assert.assertEquals(expectedTitles,actualTitles,"Actual Titles are not matching with the expected ones");


        Driver.closeDriver();

    }

    @Test
    public void US_6_SalesManager(){
       VyTrackUtils.loginAsSalesManager();

        WebElement fleet = findElementByXpath("//li[@class='dropdown dropdown-level-1']/a/span[@class='title title-level-1'and contains(text(),'Fleet')]");
        Actions hoverToFleet = new Actions(Driver.getDriver());
        hoverToFleet.moveToElement(fleet).build().perform();

        WebElement vehicles = findElementByXpath("(//li[@class='dropdown-menu-single-item first'])[2]/a");
        vehicles.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement dots = findElementByXpath("//table/tbody/tr[1]/td[@class='action-cell grid-cell grid-body-cell']");
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(dots).pause(1000).click().perform();

        String valuesOfOpenedItems= "//table/tbody/tr[1]/td[@class='action-cell grid-cell grid-body-cell']//li/ul/li/a";

        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        List<WebElement> launcherItems = new ArrayList<>(Driver.getDriver().findElements(By.xpath(valuesOfOpenedItems)));

        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        List<String> actualTitles = new ArrayList<>();
        for(WebElement each : launcherItems){
            actualTitles.add(each.getAttribute("title"));
        }
        System.out.println(actualTitles);

        List<String> expectedTitles = new ArrayList<>(Arrays.asList("View" ,"Edit", "Delete"));
        Assert.assertEquals(expectedTitles,actualTitles,"Actual Titles are not matching with the expected ones");

        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Driver.closeDriver();
    }
}
/*
Story6:  As a user, I want to see edit car info icons from the Vehicle page.
AC #1:  users should see “view, edit, delete” when they hover the mouse to the 3 dots “…”
 */