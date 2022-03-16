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

public class US_12 extends TestBase {

    @Test
    public void verifying_filter_items_as_SalesManager() {

        //User is able Log in as store or sales managers
        VyTrackUtils.loginAsSalesManager();
        BrowserUtils.sleep(5);


        //User successfully logs in, expected page title is "Dashboard".
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle);


        WebElement customersButton = Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[3]"));
        WebElement accountsButton = Driver.getDriver().findElement(By.xpath("//a[@href=\"/account\"]/span"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(customersButton).pause(1000).click().perform();
        action.moveToElement(accountsButton).pause(1000).click().perform();

        WebElement filterButton = Driver.getDriver().findElement(By.xpath("//i[@class='fa-filter hide-text']"));
        filterButton.click();
        BrowserUtils.sleep(2);

        //Expected filter names: Account Name, Contact Name, Contact Email, Contact Phone, Owner, Business Unit, Created At, Updated At
        List<WebElement> filterItems = Driver.getDriver().findElements(By.xpath("//div[@class='filter-item oro-drop']"));
        List<String> actualItemsText = new ArrayList<>();
        List<String> expectedItemsText = new ArrayList<>(Arrays.asList("Account Name: All", "Contact Name: All", "Contact Email: All", "Contact Phone: All", "Owner: All", "Business Unit: All", "Created At: All", "Updated At: All"));//?????

        for (WebElement each : filterItems) {
            String eachText = each.getText();
            actualItemsText.add(eachText);
        }

        Assert.assertEquals(actualItemsText,expectedItemsText);


    }

    @Test
    public void verifying_filter_items_as_StoreManager() {

        //User is able Log in as store or sales managers
        VyTrackUtils.loginAsStoreManger();
        BrowserUtils.sleep(5);


        //User successfully logs in, expected page title is "Dashboard".
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle);


        WebElement customersButton = Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[3]"));
        WebElement accountsButton = Driver.getDriver().findElement(By.xpath("//a[@href=\"/account\"]/span"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(customersButton).pause(1000).click().perform();
        action.moveToElement(accountsButton).pause(1000).click().perform();

        WebElement filterButton = Driver.getDriver().findElement(By.xpath("//i[@class='fa-filter hide-text']"));
        filterButton.click();
        BrowserUtils.sleep(2);

        //Expected filter names: Account Name, Contact Name, Contact Email, Contact Phone, Owner, Business Unit, Created At, Updated At
        List<WebElement> filterItems = Driver.getDriver().findElements(By.xpath("//div[@class='filter-item oro-drop']"));
        List<String> actualItemsText = new ArrayList<>();
        List<String> expectedItemsText = new ArrayList<>(Arrays.asList("Account Name: All", "Contact Name: All", "Contact Email: All", "Contact Phone: All", "Owner: All", "Business Unit: All", "Created At: All", "Updated At: All"));//?????

        for (WebElement each : filterItems) {
            String eachText = each.getText();
            actualItemsText.add(eachText);
        }

        Assert.assertEquals(actualItemsText,expectedItemsText);


    }
}
