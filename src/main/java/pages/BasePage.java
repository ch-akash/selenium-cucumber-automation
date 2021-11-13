package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private final WebDriverWait webDriverWait;
    protected final WebDriver driver;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    protected void waitForElementVisibility(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForFrameToLoadThenSwitchToIt(String frameLocator) {
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    protected void waitForElementVisibility(By element) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void waitForElementClickable(By element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
