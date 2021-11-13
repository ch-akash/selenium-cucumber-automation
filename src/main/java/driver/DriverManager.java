package driver;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import utils.WebDriverUtil;

import static utils.WebDriverUtil.getBrowserName;

public class DriverManager {

    public static WebDriver getDriver() {
        final String browserName = getBrowserName();

        if (Browser.CHROME.browserName().equalsIgnoreCase(browserName)) {
            return WebDriverUtil.getChromeDriver();
        } else if (Browser.SAFARI.browserName().equalsIgnoreCase(browserName) && System.getProperty("os.name").contains("macOS")) {
            return WebDriverUtil.getSafariDriver();
        } else if (Browser.FIREFOX.browserName().equalsIgnoreCase(browserName)) {
            return WebDriverUtil.getFirefoxDriver();
        }
        throw new InvalidArgumentException("Invalid browser name or browser not compatible with OS.");
    }
}
