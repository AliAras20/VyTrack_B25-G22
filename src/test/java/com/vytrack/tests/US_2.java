package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class US_2 {


    @Test
    public void verify_Doc_Page(){

        VyTrackUtils.loginAsSalesManager();
        BrowserUtils.sleep(2);

        WebElement helpButton= Driver.getDriver().findElement(By.xpath("//i[@title='Get help']"));
        helpButton.click();

        Set <String> windowHandles= Driver.getDriver().getWindowHandles();

        for( String eachWindow : windowHandles){

            Driver.getDriver().switchTo().window(eachWindow);

        }


        String actualUrl= Driver.getDriver().getCurrentUrl();
        String ExpectedURL= "https://doc.oroinc.com/";
        Assert.assertEquals(actualUrl, ExpectedURL);
    }
}
