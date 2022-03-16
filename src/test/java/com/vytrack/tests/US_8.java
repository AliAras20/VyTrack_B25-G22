package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_8 extends TestBase {


    @Test
    public void driverLogIn()throws InterruptedException {
        VyTrackUtils.loginAsDriver();
        WebElement activitiesTab = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span"));
        activitiesTab.click();
        WebElement calendarEvents = Driver.getDriver().findElement(By.linkText("Calendar Events"));
        calendarEvents.click();

        WebElement createCalendarEventButton = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(5000);
        actions.moveToElement(createCalendarEventButton).click().perform();
        WebElement repeatCheckBox = Driver.getDriver().findElement(By.xpath("//*[@id=\"recurrence-repeat-view237\"]"));
        Thread.sleep(5000);
        repeatCheckBox.click();
        WebElement daysBox = Driver.getDriver().findElement(By.xpath("//input[@class='recurrence-subview-control__number']"));
        daysBox.clear();

        WebElement warningNote = Driver.getDriver().findElement(By.xpath("//*[@id=\"temp-validation-name-261-error\"]/span/span"));
        Assert.assertEquals(true, warningNote.isDisplayed());
    }
    @Test
    public void salesManager() throws InterruptedException{
        VyTrackUtils.loginAsSalesManager();
        WebElement activitiesTab = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span"));
        activitiesTab.click();
        WebElement calendarEvents = Driver.getDriver().findElement(By.linkText("Calendar Events"));
        calendarEvents.click();

        WebElement createCalendarEventButton = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(5000);
        actions.moveToElement(createCalendarEventButton).click().perform();
        WebElement repeatCheckBox = Driver.getDriver().findElement(By.xpath("//*[@id=\"recurrence-repeat-view239\"]"));
        Thread.sleep(8000);
       repeatCheckBox.click();
        WebElement daysBox = Driver.getDriver().findElement(By.xpath("//input[@class='recurrence-subview-control__number']"));
       daysBox.clear();

        WebElement warningNote = Driver.getDriver().findElement(By.xpath("//*[@id=\"temp-validation-name-263-error\"]/span/span"));
        Assert.assertEquals(true, warningNote.isDisplayed());

    }
    @Test
    public void StoreManager() throws InterruptedException {
        VyTrackUtils.loginAsStoreManger();
        WebElement activitiesTab = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]"));
        Thread.sleep(3000);
        activitiesTab.click();
        WebElement calendarEvents = Driver.getDriver().findElement(By.linkText("Calendar Events"));
       calendarEvents.click();

        WebElement createCalendarEventButton = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(5000);
        actions.moveToElement(createCalendarEventButton).click().perform();
       WebElement repeatCheckBox = Driver.getDriver().findElement(By.cssSelector("#recurrence-repeat-view239"));
        Thread.sleep(6000);
        repeatCheckBox.click();
       WebElement daysBox = Driver.getDriver().findElement(By.xpath("//input[@class='recurrence-subview-control__number']"));
       daysBox.clear();
Thread.sleep(5000);
        WebElement warningNote = Driver.getDriver().findElement(By.xpath("//*[@id=\"temp-validation-name-263-error\"]/span/span"));
      Assert.assertEquals(true, warningNote.isDisplayed());


    }
}
