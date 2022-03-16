package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_3 extends TestBase {

    @DataProvider(name = "roles")
    public Object[][] provideRoles(){
        return new Object[][]{{"salesmanager"},{"storemanager"},{"driver"}};
    }


    //As a user, I want to learn how to use the pinbar.
    //AC1: when users  click the “Learn how to use this space” link on the homepage, users should see:
    //“How To Use Pinbar” and
    //“Use pin icon on the right top corner of the page to create fast access link in the pinbar.”
    @Test(dataProvider = "roles")
    public void pinBar_header_test(String role){

        // log in to the home page
        if (role.equals("salesmanager"))
            VyTrackUtils.loginAsSalesManager();
        else if (role.equals("storemanager"))
            VyTrackUtils.loginAsStoreManger();
        else VyTrackUtils.loginAsDriver();


        // locate and click on the “Learn how to use this space” link
        Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']")).click();

        // verify that users should see:
        //    “How To Use Pinbar” header
        String expectedHeader = "How To Use Pinbar";
        String actualHeader = Driver.getDriver().findElement(By.xpath("(//h3)[2]")).getText();

        Assert.assertEquals(actualHeader,expectedHeader);




    }

    @Test (dataProvider = "roles")
    public void pinBar_paragraph_test(String role){

        // log in to the home page
        if (role.equals("salesmanager"))
            VyTrackUtils.loginAsSalesManager();
        else if (role.equals("storemanager"))
            VyTrackUtils.loginAsStoreManger();
        else VyTrackUtils.loginAsDriver();

        // locate and click on the “Learn how to use this space” link
        Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']")).click();

        // verify that users should see:
        //  “Use pin icon on the right top corner of the page to create fast access link in the pinbar.” paragraph
        String expectedParText = "Use pin icon on the right top corner of the page to create fast access link in the pinbar.";
        String actualParText = Driver.getDriver().findElement(By.xpath("(//p)[1]")).getText();

        Assert.assertEquals(actualParText,expectedParText);




    }


    //AC2: users should see an image on the page.
    //[in automation testing, just verify the image source.]
    //Expected source: /bundles/oronavigation/images/pinbar-location.jpg
    @Test (dataProvider = "roles")
    public void image_test(String role){

        // log in to the home page
        if (role.equals("salesmanager"))
            VyTrackUtils.loginAsSalesManager();
        else if (role.equals("storemanager"))
            VyTrackUtils.loginAsStoreManger();
        else VyTrackUtils.loginAsDriver();

        // locate and click on the “Learn how to use this space” link
        Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']")).click();

        // locate the image and get it source attribute value
        String expectedSRCValue = "/bundles/oronavigation/images/pinbar-location.jpg";
        String actualSRCValue = Driver.getDriver().findElement(By.xpath("//img")).getAttribute("src");

        // verify that the actual value match expected one
        // !!! should it contain it or be the same????
        Assert.assertTrue(actualSRCValue.contains(expectedSRCValue));


    }

}
