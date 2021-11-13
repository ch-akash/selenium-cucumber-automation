package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverUtil {

    public static ChromeDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(isHeadlessSetTrue());
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    public static FirefoxDriver getFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(isHeadlessSetTrue());
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }

    public static SafariDriver getSafariDriver() {
        WebDriverManager.chromedriver().setup();
        return new SafariDriver();
    }

    @SneakyThrows
    public static String getBrowserName() {
        return PropertyUtil.getPropertyValue("browser.name", "test.properties");
    }

    @SneakyThrows
    private static boolean isHeadlessSetTrue() {
        return Boolean.parseBoolean(PropertyUtil.getPropertyValue("run.headless", "test.properties"));
    }
}
