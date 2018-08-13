package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait {
    private WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait createWait(long timeout) {
        return new WebDriverWait(driver, timeout);
    }

    public void wait(ExpectedCondition<?> condition, int waitTime) {
        try {
            this.createWait(waitTime)
                    .pollingEvery(300, TimeUnit.MILLISECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .until(condition);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void clickableWithWait (WebElement element, int waitTime) {
        wait(ExpectedConditions.elementToBeClickable(element), waitTime);
    }

    public void clickable(WebElement element) {
        clickableWithWait(element, 10);
    }

    public void clickableThenClick(WebElement element) {
        this.clickableThenClick(element, 10);
    }

    public void clickableThenClick(WebElement element, int waitTime) {
        wait(ExpectedConditions.elementToBeClickable(element), waitTime);
        element.click();
    }

    public void visibleThenClick(WebElement element) {
        this.visibleThenClick(element, 10);
    }

    public void visibleThenClick(WebElement element, int waitTime) {
        wait(ExpectedConditions.visibilityOf(element), waitTime);
        element.click();
    }

    public void visible(WebElement element) {
        visible(element, 10);
    }

    public void visible(WebElement element, int waitTime) {
        wait(ExpectedConditions.visibilityOf(element), waitTime);
    }
}
