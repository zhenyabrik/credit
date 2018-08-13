package testcases.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.base.BasePage;
import pages.MyWalletNetUaPage;
import pages.SravniZaymPage;
import utils.Log;
import utils.TestListener;
import utils.Wait;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected Wait wait;
    protected Log log;

    private WebDriver driver;
    private final int IMPLICIT_WAIT = 10;

    public SravniZaymPage sravniZaymPage;
    public MyWalletNetUaPage myWalletNetUa;
    public TestListener testListener;
    public BasePage basePage;

    public void createMyDriver() {
        DesiredCapabilities capability;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

        capability = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capability);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        createMyDriver();
        wait = new Wait(driver);
        log = new Log();
        testListener = new TestListener();
        basePage = new BasePage(driver, wait);
        sravniZaymPage = new SravniZaymPage(driver);
        myWalletNetUa = new MyWalletNetUaPage(driver);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
