package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class US_7 extends TestBase {


        @Test
        public void testAC1_sales_manager() {
            VyTrackUtils.loginAsSalesManager();
            waitTillLoaderMaskDisappear();

            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[@id='main-menu']//span[contains(.,'Fleet')])[1]")))
                    .pause(1000).click(Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"))).perform();

            BrowserUtils.sleep(2);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElements(By.xpath("//tbody//input[@type='checkbox']")).get(0)));

            List<WebElement> boxes = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));

            for (WebElement eachBox : boxes) {
                Assert.assertFalse(eachBox.isSelected());
            }
        }


        @Test
        public void testAC1_store_manager() {
            VyTrackUtils.loginAsStoreManger();
            waitTillLoaderMaskDisappear();

            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[@id='main-menu']//span[contains(.,'Fleet')])[1]")))
                    .pause(1000).click(Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"))).perform();

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElements(By.xpath("//tbody//input[@type='checkbox']")).get(0)));
            List<WebElement> boxes = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));

            for (WebElement eachBox : boxes) {
                Assert.assertFalse(eachBox.isSelected());
            }
        }

        @Test
        public void testAC1_driver() {
            VyTrackUtils.loginAsSalesManager();
            waitTillLoaderMaskDisappear();

            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[@id='main-menu']//span[contains(.,'Fleet')])[1]")))
                    .pause(1000).click(Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"))).perform();

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElements(By.xpath("//tbody//input[@type='checkbox']")).get(0)));
            List<WebElement> boxes = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));

            for (WebElement eachBox : boxes) {
                Assert.assertFalse(eachBox.isSelected());
            }
        }

        @Test
        public void testAC2_sales_manager() {
            VyTrackUtils.loginAsSalesManager();
            waitTillLoaderMaskDisappear();

            Actions actions = new Actions(Driver.getDriver());

            actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[@id='main-menu']//span[contains(.,'Fleet')])[1]"))).click().perform();
            waitTillLoaderMaskDisappear();

            actions.moveToElement(Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"))).click().perform();
            BrowserUtils.sleep(1);

            Driver.getDriver().findElement(By.xpath("//table/thead//input[@type='checkbox']")).click();
            waitTillLoaderMaskDisappear();

            List<WebElement> checkedBoxes = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));
            for (WebElement eachCheckedBox : checkedBoxes) {

                Assert.assertTrue(eachCheckedBox.isSelected());
            }
        }

        @Test
        public void testAC2_store_manager() {

            VyTrackUtils.loginAsStoreManger();
            waitTillLoaderMaskDisappear();

            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[@id='main-menu']//span[contains(.,'Fleet')])[1]"))).click().perform();
            BrowserUtils.sleep(2);

            actions.moveToElement(Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"))).click().perform();
            BrowserUtils.sleep(2);

            Driver.getDriver().findElement(By.xpath("//table/thead//input[@type='checkbox']")).click();
            waitTillLoaderMaskDisappear();

            List<WebElement> checkedBoxes = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));
            for (WebElement eachCheckedBox : checkedBoxes) {

                Assert.assertTrue(eachCheckedBox.isSelected());
            }
        }

    @Test
    public void testAC2_driver() throws InterruptedException {
        VyTrackUtils.loginAsDriver();
        waitTillLoaderMaskDisappear();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[@id='main-menu']//span[contains(.,'Fleet')])[1]"))).click().perform();
        BrowserUtils.sleep(2);
        try {
            actions.moveToElement(Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"))).click().perform();
            List<WebElement> checkedBoxes = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));
            for (WebElement eachCheckedBox : checkedBoxes) {
                Assert.assertFalse(eachCheckedBox.isSelected());}
            Thread.sleep(1000);
        } catch(org.openqa.selenium.NoSuchElementException | org.openqa.selenium.ElementClickInterceptedException e)
        {
            e.printStackTrace();
        }
    }
        @Test
        public void testAC3_sales_manager() {

            VyTrackUtils.loginAsSalesManager();
            waitTillLoaderMaskDisappear();

            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[@id='main-menu']//span[contains(.,'Fleet')])[1]"))).click().perform();
            BrowserUtils.sleep(2);

            actions.moveToElement(Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"))).click().perform();
            BrowserUtils.sleep(2);

            List<WebElement> boxes = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));

            Faker faker = new Faker();
            int num = faker.number().numberBetween(1, boxes.size());

            boxes.get(num).click();

            waitTillLoaderMaskDisappear();
            Assert.assertTrue(boxes.get(num).isSelected());

        }

        @Test
        public void testAC3_store_manager() {

            VyTrackUtils.loginAsStoreManger();

            waitTillLoaderMaskDisappear();

            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[@id='main-menu']//span[contains(.,'Fleet')])[1]"))).click().perform();
            BrowserUtils.sleep(2);

            actions.moveToElement(Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"))).click().perform();
            BrowserUtils.sleep(2);

            List<WebElement> boxes = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));

            Faker faker = new Faker();
            int num = faker.number().numberBetween(1, boxes.size());

            boxes.get(num).click();

            waitTillLoaderMaskDisappear();

            Assert.assertTrue(boxes.get(num).isSelected());

        }

        @AfterMethod
        public void logOut() {
            Driver.getDriver().findElement(By.xpath("//*[@id='user-menu']/a")).click();
            BrowserUtils.sleep(2);

            Driver.getDriver().findElement(By.xpath("//li/a[@href='/user/logout']")).click();
        }

        @AfterTest
        public void teardown() {
            Driver.getDriver().close();
        }


        public void waitTillLoaderMaskDisappear() {
            try {
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

                WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));

                wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
