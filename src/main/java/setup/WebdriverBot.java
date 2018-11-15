package setup;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.Const;

import java.util.List;

/**
 * @Author by jcampos on 16/02/2016.
 */
public class WebdriverBot {

    /**
     * Attributes
     */
    private static WebDriver driver;

    /**
     * constructor
     *
     * @param driver instance of the web driver
     */
    public WebdriverBot(WebDriver driver) {
        this.driver = driver;
    }

    //<editor-fold desc="Click Elements Methods">

    /**
     * Click on the element
     *
     * @param element element to click
     */
    public static void clickElement(WebElement element) {
        try {
            waitUntilElementIsDisplayed(element);
            element.click();
        } catch (NoSuchElementException ex) {
            throw new RuntimeException(String.format("There was a problem clicking the element. %s :,%s", element, ex));
        } catch (StaleElementReferenceException e) {
            throw new RuntimeException(String.format("There was a problem clicking the element. %s :,%s", element, e));
        } catch (ElementNotVisibleException exc) {
            throw new RuntimeException(String.format("There was a problem clicking on the element: %s, %s ", element, exc));
        } catch (InvalidElementStateException ex) {
            throw new RuntimeException(String.format("There was a problem clicking on the element: %s, %s"
                    , element, ex));
        }
    }

    /**
     * Click on the element
     *
     * @param by element to click
     */
    public static void clickElement(By by) {
        try {
            waitUntilElementIsDisplayed(by);
            findElement(by).click();
        } catch (NoSuchElementException ex) {
            throw new RuntimeException(String.format("There was a problem clicking the element. %s :,%s", by, ex));
        } catch (StaleElementReferenceException e) {
            throw new RuntimeException(String.format("There was a problem clicking the element. %s :,%s", by, e));
        } catch (ElementNotVisibleException exc) {
            throw new RuntimeException(String.format("There was a problem clicking on the element: %s, %s ", by, exc));
        } catch (InvalidElementStateException ex) {
            throw new RuntimeException(String.format("There was a problem clicking on the element: %s, %s"
                    , by, ex));
        }
    }

    //</editor-fold>

    //<editor-fold desc="Select Elements Methods">

    /**
     * Select a value from a dropdown according to the text it gets
     *
     * @param locator     locator to find out
     * @param visibleText text that should be visible in the dropdown
     */
    public static void selectDropDownValueByVisibleText(final By locator, String visibleText) {
        try {
            WebElement activeElement = driver.findElement(locator);
            Select select = new Select(activeElement);
            select.selectByVisibleText(visibleText);
        } catch (UnexpectedTagNameException e) {
            throw new RuntimeException(String.format("There was a problem selecting an option by text from the dropdown " +
                    "with the locator: %s,%s", locator, e));
        } catch (InvalidElementStateException ex) {
            throw new RuntimeException(String.format("There was a problem selecting an option from the dropdown " +
                    "with the locator: %s,%s", locator, ex));
        }
    }

    //</editor-fold>

    //<editor-fold desc="Elements Methods">

    /**
     * Get the parent element for a web element
     *
     * @param wElement web element to get the parent
     * @return Web element
     */
    public static WebElement getParentElement(WebElement wElement) {
        try {
            return wElement.findElement(By.xpath(".."));
        } catch (InvalidSelectorException ex) {
            throw new RuntimeException(String.format("There was a problem looking for the element. %s, %s", wElement, ex));
        } catch (ElementNotVisibleException exc) {
            throw new RuntimeException(String.format("There was a problem looking for the element. %s, %s", wElement, exc));
        } catch (StaleElementReferenceException exc) {
            throw new RuntimeException(String.format("There was a problem looking for the element. %s, %s", wElement, exc));
        }
    }

    /**
     * Find all the element with the locator passes as parameter
     *
     * @param locator element to find
     * @return List of elements
     */
    public static List<WebElement> findElements(By locator) {
        try {
            return driver.findElements(locator);
        } catch (InvalidSelectorException ex) {
            throw new RuntimeException(String.format("There was a problem looking for the element. %s, %s", locator, ex));
        } catch (StaleElementReferenceException exc) {
            throw new RuntimeException(String.format("There was a problem looking for the element. %s, %s", locator, exc));
        }
    }

    /**
     * Find element to use it
     *
     * @param locator locator to find
     * @return Web element
     */
    public static WebElement findElement(By locator) {
        try {
            if (findElements(locator).size() > 0) {
                return driver.findElement(locator);
            } else {
                return null;
            }
        } catch (InvalidSelectorException ex) {
            throw new RuntimeException(String.format("There was a problem looking for the element. %s, %s", locator, ex));
        } catch (StaleElementReferenceException exc) {
            throw new RuntimeException(String.format("There was a problem looking for the element. %s, %s", locator, exc));
        }
    }

    //</editor-fold>

    //<editor-fold desc="Wait Elements Methods">


    /**
     * Wait until the element is displayed in the UI
     *
     * @param elementLocator locator to find out
     */
    public static void waitUntilElementIsDisplayed(By elementLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Const.WAIT_TIME);
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        } catch (TimeoutException e) {
            throw new RuntimeException(String.format("Timeout waiting for the element: %s :,%s", elementLocator, e));
        }
    }

    /**
     * Wait until the element is displayed
     *
     * @param wElement element to wait
     */
    public static void waitUntilElementIsDisplayed(WebElement wElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Const.WAIT_TIME);
            wait.until(ExpectedConditions.visibilityOf(wElement));
        } catch (TimeoutException e) {
            throw new RuntimeException(String.format("Timeout waiting for the element: %s :,%s", wElement, e));
        }
    }

    /**
     * This method wait that the element is present in order to perform the following action
     *
     * @param element element to wait
     * @return boolean
     */
    public static boolean waitForElementVisible(final By element) {
        boolean isElementVisible = true;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Const.WAIT_TIME);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException te) {
            isElementVisible = false;
        }
        return isElementVisible;
    }

    /**
     * This method wait that the element is not visible in order to perform the following action
     *
     * @param element element to wait
     * @return boolean
     */
    public static boolean waitForElementInvisible(final By element) {
        boolean isElementInvisible = true;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Const.WAIT_TIME);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (TimeoutException te) {
            isElementInvisible = false;
        }
        return isElementInvisible;
    }

    //</editor-fold>

    /**
     * Type a text into a field
     *
     * @param locator locator to use
     * @param text    text to type
     */
    public static void sendKeysWithClear(By locator, String text) {
        try {
            WebElement wElement = driver.findElement(locator);
            wElement.clear();
            wElement.sendKeys(text);
        } catch (ElementNotVisibleException exc) {
            throw new RuntimeException(String.format("There was a problem typing a text in the locator: %s, %s", locator, exc));
        } catch (InvalidElementStateException ex) {
            throw new RuntimeException(String.format("There was a problem typing a text in the locator: %s, %s", locator, ex));
        } catch (WebDriverException ex) {
            throw new RuntimeException(String.format("There was a problem typing a text in the locator: %s, %s", locator, ex));
        }
    }

}
