package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Log;
import java.util.*;

public class SravniZaymPage {

    private WebDriver driver;
    public final static String URL = "https://sravnizajm.com.ua/vyberi-luchshij-kredit-onlajn/?gclid=EAIaIQobChMIgs-6kbra3AIVA90bCh2WQwXUEAAYASAAEgKI3PD_BwE";

    public SravniZaymPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[@class='noUi-pips noUi-pips-horizontal'])[1]")
    private WebElement slider;
    @FindBy(xpath = "(//*[@class='noUi-value noUi-value-horizontal noUi-value-large'])[3]")
    public WebElement creditAmountField;

    public WebElement getSlider() {
        return slider;
    }

    public void openPage(String pages) {
        driver.get(pages);
    }

    public void moveCreditAmountSlider(WebElement element) {
        int x = 40;
        int width = element.getSize().getWidth();
        Actions move = new Actions(driver);
        move.moveToElement(element, ((width * x) / 100), 0).click();
        move.build().perform();
    }

    public void clickOnApplyButton() {
        /**commissions*/
        // find all commission
        List<WebElement> commissionList = driver.findElements(By.xpath("//ul[@class='noFirst']//div[3]/span[@class='value']/div[@class='cell']/span"));
        // get text from elements(commissions size)
        ArrayList<String> obtainedCommissionList = new ArrayList();
        for(WebElement we:commissionList){
            obtainedCommissionList.add(we.getText());
        }
        // convert list from String to Integer
        ArrayList<Integer> commissionListWithValues = new ArrayList(obtainedCommissionList.size()) ;
        for (String myInt : obtainedCommissionList) {
            commissionListWithValues.add(Integer.valueOf(myInt));
        }
        Log.info("commissions are: " + commissionListWithValues);
        // get index of min value
        int minIndex = (commissionListWithValues.indexOf(Collections.min(commissionListWithValues))+1);
        Log.info("indexOf Min value " + (minIndex - 1));

        /**buttons*/
        String lowestCommissionApplyButtonXpath = "(//ul[@class='noFirst']//div[@class='apply']//a[@class='submit'])" + "[" + minIndex + "]";
        driver.findElement(By.xpath(lowestCommissionApplyButtonXpath)).click();
    }
}
