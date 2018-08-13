package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWalletNetUaPage {

    private WebDriver driver;

    public MyWalletNetUaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "calc")
    private WebElement calcBody;
    @FindBy(id = "amountval-val")
    public WebElement creditAmountField;
    @FindBy(className = "amount-to-return")
    private WebElement amountToReturnField;

    public WebElement getCalcBody() {
        return calcBody;
    }

    public WebElement getCreditAmountField() {
        return creditAmountField;
    }

    public WebElement getAmountToReturnField() {
        return amountToReturnField;
    }

    public String getCreditAmount(WebElement element) {
        return element.getText();
    }

    public String getCreditAmount2(WebElement element) {
        return element.getAttribute("span");
    }

}
