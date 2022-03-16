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

public class US_10 extends TestBase {
    @Test
    public void description_Message_When_Creating_CalendarEvent(){
        VyTrackUtils.loginAsDriver();
        WebElement activitiesDropdown = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.moveToElement(activitiesDropdown).perform();

        WebElement calendarEventTab = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[9]"));
        calendarEventTab.click();

        WebElement createEventTab = Driver.getDriver().findElement(By.xpath("//div/a[@title='Create Calendar event']"));
        createEventTab.click();

        WebElement iframe = Driver.getDriver().findElement(By.xpath("(//iframe)[1]"));
        Driver.getDriver().switchTo().frame(iframe);
        Driver.getDriver().findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Test1");


        WebElement message = Driver.getDriver().findElement(By.xpath("//p"));
        Assert.assertTrue(message.isDisplayed());
        Driver.getDriver().switchTo().parentFrame();
    }
}
