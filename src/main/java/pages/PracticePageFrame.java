package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticePageFrame extends PracticePage {


    private final By joinNowButton = By.xpath("//a[text()='JOIN NOW']");

    public PracticePageFrame(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickJoinNow() {
        this.waitForElementClickable(joinNowButton);
        this.driver.findElement(joinNowButton).click();
    }
}
