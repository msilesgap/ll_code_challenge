package setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestCase extends TestCaseBase {

    /**
     * This method overrides the setUp method from TestCaseBase class
     *
     * @param browserName
     */
    @Parameters({"browser", "serverURL"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browserName, String url) {
        super.setUp(browserName, url);
    }

    /**
     * This method overrides the quitBrowser method inherited from TestCaseBase class
     */
    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        super.quitBrowser();
    }

    /**
     * This method gets the actual instance of webDriver
     *
     * @return webdriver instance the getDriver method inherited from TestCaseBase class
     */
    public WebDriver getDriverInstance() {
        return super.getDriver();
    }
}
