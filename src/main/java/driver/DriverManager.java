package driver;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import utils.WebDriverUtil;

import static utils.WebDriverUtil.getBrowserName;

public class DriverManager {


    public static WebDriver getDriver() {

        String browserName = getBrowserName();

        if (Browser.CHROME.browserName().equalsIgnoreCase(browserName)) {
            return WebDriverUtil.getChromeDriver();

        } else if (Browser.SAFARI.browserName().equalsIgnoreCase(browserName)) {
            return WebDriverUtil.getSafariDriver();
        }
        throw new InvalidArgumentException("Invalid browser name");
    }


}
