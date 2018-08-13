package pages.base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Wait;


import java.util.ArrayList;

public class BasePage{

    public WebDriver driver;
    protected Wait wait;

    public BasePage(WebDriver driver, Wait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //asserts
    public void assertStrings(String stringActual, String stringExpected)  {
        try {
            Assert.assertEquals(stringActual, stringExpected);
        }catch (AssertionError assertionException){
            assertionException.printStackTrace();
            throw assertionException;
        }
    }

    public void assertObjects(Object objectActual, Object objectExpected)  {
        try {
            Assert.assertEquals(objectActual, objectExpected);
        }catch (AssertionError assertionException){
            assertionException.printStackTrace();
            throw assertionException;
        }
    }

    public void moveToSecondWindow() {
        ArrayList<String> tabsWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsWindows.get(1));
    }
}
