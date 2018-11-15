package setup;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import utils.Const;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class TestCaseBase {

    protected WebDriver driver;
    protected String browserName;

    /**
     * This method returns the driver to be used.
     *
     * @return driver to be used in the proofs
     */
    public WebDriver getDriver() {
        return this.driver;
    }

    /**
     * This method configure the browser for the tests
     *
     * @param browserName the browser in which the test will run
     * @param url to execute the tests
     */
    public void setUp(String browserName, String url) {
        try {
            String os = System.getProperty("os.name");
            DesiredCapabilities capabilities;
            switch (browserName.toLowerCase()) {
                case Const.CHROME_BROWSER:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    StringBuilder chromeDriverPath = new StringBuilder();
                    if (os.contains("Win")) {
                        chromeDriverPath.append(System.getProperty("user.dir")).append
                                ("\\src\\main\\resources\\selenium_standalone_binaries\\windows\\googlechrome\\64bit\\chromedriver.exe").toString();
                    } else if (os.contains("Mac")) {
                        chromeDriverPath.append(System.getProperty("user.dir")).append
                                ("/src/main/resources/selenium_standalone_binaries/osx/googlechrome/64bit/chromedriver").toString();
                    } else {
                        chromeDriverPath.append(System.getProperty("user.dir")).append
                                ("/src/main/resources/selenium_standalone_binaries/linux/googlechrome/64bit/chromedriver").toString();
                    }
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath.toString());
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);

                    chromeOptions.addArguments("chrome.switches", "--disable-extensions");
                    //To Disable any browser notifications
                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--disable-infobars");
                    chromeOptions.addArguments("--test-type");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    System.setProperty("webdriver.chrome.logfile", "logs/chromedriver.log");
                    System.setProperty("webdriver.chrome.verboseLogging", "true");
                    //chromeOptions.setHeadless(true);
                    ChromeDriverService service = new ChromeDriverService.Builder()
                            .usingDriverExecutable(new File(chromeDriverPath.toString()))
                            .usingAnyFreePort()
                            .build();
                    driver = new ChromeDriver(service, chromeOptions);
                    break;

                case Const.FIREFOX_BROWSER:
                    System.out.println("Firefox driver detected for: " + os);
                    StringBuilder marionetteDriverPath = new StringBuilder();
                    if (os.toLowerCase().contains("win")) {
                        System.out.println("Setting up Firefox driver for: " + os);
                        marionetteDriverPath.append(System.getProperty("user.dir")).append
                                ("\\src\\main\\resources\\selenium_standalone_binaries\\windows\\marionette\\64bit\\geckodriver.exe").toString();
                    } else if (os.toLowerCase().contains("mac")) {
                        System.out.println("Setting up Firefox driver for: " + os);
                        marionetteDriverPath.append(System.getProperty("user.dir")).append
                                ("/src/main/resources/selenium_standalone_binaries/osx/marionette/64bit/geckodriver").toString();
                    } else if (os.toLowerCase().indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0) {
                        System.out.println("Setting up Firefox driver for: " + os);
                        marionetteDriverPath.append(System.getProperty("user.dir")).append
                                ("/src/main/resources/selenium_standalone_binaries/linux/marionette/64bit/geckodriver").toString();
                    }
                    System.out.println(marionetteDriverPath.toString());
                    System.setProperty("webdriver.gecko.driver", marionetteDriverPath.toString());
                    FirefoxOptions firefoxOptions = new FirefoxOptions().setLogLevel(Level.OFF);
                    //firefoxOptions.setHeadless(true);
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case Const.GECKO_BROWSER:
                    StringBuilder geckoDriverPath = new StringBuilder();
                    if (os.contains("win"))
                        geckoDriverPath.append(System.getProperty("user.dir")).append
                                ("\\src\\main\\resources\\selenium_standalone_binaries\\windows\\geckodriver\\64bit\\geckodriver.exe").toString();
                    else if (os.contains("mac"))
                        geckoDriverPath.append(System.getProperty("user.dir")).append
                                ("/src/main/resources/selenium_standalone_binaries/mac/geckodriver/64bit/geckodriver").toString();
                    else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0) {
                        geckoDriverPath.append(System.getProperty("user.dir")).append
                                ("/src/main/resources/selenium_standalone_binaries/linux/geckodriver/64bit/geckodriver").toString();
                    }
                    System.setProperty("webdriver.gecko.driver", geckoDriverPath.toString());
                    driver = new FirefoxDriver();
                    break;
                case Const.EDGE_BROWSER:
                    capabilities = DesiredCapabilities.internetExplorer();
                    capabilities.setCapability("ignoreZoomSetting", true);
                    capabilities.setCapability("nativeEvents", false);
                    capabilities.setCapability("ignoreProtectedModeSettings", true);
                    capabilities.setCapability("disable-popup-blocking", true);
                    driver = new EdgeDriver(capabilities);
                    this.browserName = capabilities.getBrowserName();
                    break;
                case Const.SAFARI_BROWSER:
                    driver = new SafariDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.get(url);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Quit browser after execute the test
     */
    protected void quitBrowser() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            driver.quit();
            throw e;
        }
    }
}
