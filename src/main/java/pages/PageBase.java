package pages;

import org.openqa.selenium.WebDriver;
import setup.WebdriverBot;


public class PageBase {

    /**
     * Attributes
     */
    protected WebdriverBot webdriverBot;
    protected WebDriver driver;

    /**
     * Constructor
     * @param webDriver webDriver instance
     */
    public PageBase(WebDriver webDriver) {
        webdriverBot = new WebdriverBot(webDriver);
        this.driver = webDriver;
    }

}
