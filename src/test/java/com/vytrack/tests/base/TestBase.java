package com.vytrack.tests.base;

import com.vytrack.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.vytrack.utilities.Driver;

public class TestBase {
    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }






}
