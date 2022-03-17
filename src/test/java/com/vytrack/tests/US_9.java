package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class US_9 extends TestBase {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Test
    public void testNumberLessThan_0_SalesManager() {

        VyTrackUtils.loginAsSalesManager();

        waitTillLoaderMaskDisappear();

        Actions action = new Actions(Driver.getDriver());

        Faker faker = new Faker();

        int lessThan_1 = faker.number().numberBetween(-50, 0);


        action.moveToElement(Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]"))).pause(1000).click(Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"))).perform();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"))));

        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"))));

        Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"))));

        WebElement repeatDayIB = Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"));

        repeatDayIB.clear();

        repeatDayIB.sendKeys("" + lessThan_1);

        assertEquals(Driver.getDriver().findElement(By.xpath("//span[contains(@id,'temp-validation-name')]/span")).getText(), "The value have not to be less than 1.");
    }

    @Test
    public void testNumber2LessThan_0_StoreManager() {

        VyTrackUtils.loginAsStoreManger();

        waitTillLoaderMaskDisappear();

        Actions action = new Actions(Driver.getDriver());

        Faker faker = new Faker();

        int lessThan_1 = faker.number().numberBetween(-50, 0);


        action.moveToElement(Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]"))).pause(1000).click(Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"))).perform();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"))));

        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"))));

        Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"))));

        WebElement repeatDayIB = Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"));

        repeatDayIB.clear();

        repeatDayIB.sendKeys("" + lessThan_1);

        assertEquals(Driver.getDriver().findElement(By.xpath("//span[contains(@id,'temp-validation-name')]/span")).getText(), "The value have not to be less than 1.");
    }

    @Test
    public void testNumber3LessThan_0_Driver() {

        VyTrackUtils.loginAsDriver();

        waitTillLoaderMaskDisappear();

        Actions action = new Actions(Driver.getDriver());

        Faker faker = new Faker();

        int lessThan_1 = faker.number().numberBetween(-50, 0);


        action.moveToElement(Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]"))).pause(1000).click(Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"))).perform();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"))));

        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"))));

        Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"))));

        WebElement repeatDayIB = Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"));

        repeatDayIB.clear();

        repeatDayIB.sendKeys("" + lessThan_1);

        assertEquals(Driver.getDriver().findElement(By.xpath("//span[contains(@id,'temp-validation-name')]/span")).getText(), "The value have not to be less than 1.");
    }

    @Test
    public void testNumberGreaterThan_99_SalesManager() {

        VyTrackUtils.loginAsSalesManager();

        waitTillLoaderMaskDisappear();

        Actions action = new Actions(Driver.getDriver());

        Faker faker = new Faker();

        int moreThan99 = faker.number().numberBetween(100, 150);


        action.moveToElement(Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]"))).pause(1000).click(Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"))).perform();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"))));

        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"))));

        Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"))));

        WebElement repeatDayIB = Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"));

        repeatDayIB.clear();

        repeatDayIB.sendKeys("" + moreThan99);

        assertEquals(Driver.getDriver().findElement(By.xpath("//span[contains(@id,'temp-validation-name')]/span")).getText(), "The value have not to be more than 99.");
    }

    @Test
    public void testNumber2GreaterThan_99_StoreManager() {

        VyTrackUtils.loginAsStoreManger();

        waitTillLoaderMaskDisappear();

        Actions action = new Actions(Driver.getDriver());

        Faker faker = new Faker();

        int moreThan99 = faker.number().numberBetween(100, 150);


        action.moveToElement(Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]"))).pause(1000).click(Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"))).perform();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"))));

        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"))));

        Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"))));

        WebElement repeatDayIB = Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"));

        repeatDayIB.clear();

        repeatDayIB.sendKeys("" + moreThan99);

        assertEquals(Driver.getDriver().findElement(By.xpath("//span[contains(@id,'temp-validation-name')]/span")).getText(), "The value have not to be more than 99.");
    }

    @Test
    public void testNumber3GreaterThan_99_Driver() {

        VyTrackUtils.loginAsDriver();

        waitTillLoaderMaskDisappear();

        Actions action = new Actions(Driver.getDriver());

        Faker faker = new Faker();

        int moreThan99 = faker.number().numberBetween(100, 150);


        action.moveToElement(Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]"))).pause(1000).click(Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"))).perform();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"))));

        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"))));

        Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"))));

        WebElement repeatDayIB = Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item']/label[@class='fields-row']/input[3]"));

        repeatDayIB.clear();

        repeatDayIB.sendKeys("" + moreThan99);

        assertEquals(Driver.getDriver().findElement(By.xpath("//span[contains(@id,'temp-validation-name')]/span")).getText(), "The value have not to be more than 99.");
    }

    public static void waitTillLoaderMaskDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


