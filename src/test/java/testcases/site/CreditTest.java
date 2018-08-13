package testcases.site;

import testcases.base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Log;
import utils.TestListener;


@Listeners(TestListener.class)
public class CreditTest extends BaseTest {

    private String expectedCreditAmount;
    private String actualCreditAmount;

    @Test()
    public void chooseCreditWithMinCommission() {
        sravniZaymPage.openPage(sravniZaymPage.URL);
        sravniZaymPage.moveCreditAmountSlider(sravniZaymPage.getSlider());

        expectedCreditAmount = myWalletNetUa.getCreditAmount(sravniZaymPage.creditAmountField);
        Log.info("expectedCreditAmount " + expectedCreditAmount);

        sravniZaymPage.clickOnApplyButton();
        basePage.moveToSecondWindow();
        wait.visible(myWalletNetUa.getCalcBody());

        actualCreditAmount = myWalletNetUa.getCreditAmount(myWalletNetUa.creditAmountField);
        Log.info("actualCreditAmount " + actualCreditAmount);

        if (actualCreditAmount.equals(expectedCreditAmount)){
            Log.info("КРЕДИТ ВЗЯТЬ МОЖНО");
        } else {
            Log.error("КРЕДИТ ВЗЯТЬ НЕЛЬЗЯ");
        }
        basePage.assertStrings(actualCreditAmount, expectedCreditAmount);
    }
}
