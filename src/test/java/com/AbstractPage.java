package com;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage {

    public static WebDriver driver;
    public static WebDriverWait wait;
    private static final int DEFAULT_WAIT = 60;

    protected Logger log = Logger.getLogger(this.getClass().getName());

    protected void goToUrl(String url) {
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    protected void untilElementAppear(By by) {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        // driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        // wait.until(ExpectedConditions.presenceOfElementLocated(by));
        // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        // wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    protected WebElement findElement(By by, int... index) throws InterruptedException {
        WebElement element;
        untilElementAppear(by);

        if (index.length == 0)
            element = driver.findElement(by);
        else
            element = driver.findElements(by).get(index[0]);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);arguments[0].focus();", element);
        //((JavascriptExecutor) driver).executeScript("arguments[0].focus();", element);

        // wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        return element;
    }

    protected List<WebElement> findElements(By by) {
        List<WebElement> webElements;
        untilElementAppear(by);
        webElements = driver.findElements(by);
        return webElements;
    }

    protected void sendKeys(By by, String text) throws InterruptedException {
        WebElement element;
        element = findElement(by);
        if (element.isEnabled()) {
            element.sendKeys(text);
        }
    }

    protected void click(By by, int... index) throws InterruptedException {
        WebElement element;
        element = findElement(by, index);
        element.click();
    }

    protected void control(boolean condition, String onTrue, String onFalse) {
        Assert.assertTrue(condition, onFalse);
        log.info(onTrue);
    }

    protected boolean isElementExist(By by) {
        return isElementExist(by, DEFAULT_WAIT);
    }

    protected boolean isElementExist(By by, int timeSeconds) {
        driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
        boolean isExist = driver.findElements(by).size() > 0;
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        return isExist;
    }

    public AbstractPage compareText(String SentText, String TextFromScreen) {
        System.out.println("Sent text: " + SentText);
        System.out.println("Text from Screen: " + TextFromScreen);
        control(TextFromScreen.contains(SentText), "Compare Successfull", "Compare is not successfull");
        return this;
    }

    protected String getTextOfElement(By by, int... index) throws InterruptedException {
        WebElement element;
        String text;
        element = findElement(by, index);
        text = element.getText();
        return text;
    }

    protected void scrollMainWindow(int numberX, int numberY) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy('" + numberX + "','" + numberY + "')", "");
    }

    protected void hoverToElement(By by) {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(by);
        action.moveToElement(we).build().perform();
    }
}
