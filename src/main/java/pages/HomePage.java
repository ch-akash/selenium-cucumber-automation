package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "input[title='Search']")
    private WebElement searchBox;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void searchForKeyword(String keyword) {
        this.waitForElementVisibility(searchBox);
        this.searchBox.click();
        this.searchBox.sendKeys(keyword);
    }

    public void open() {
        this.driver.get("https://www.google.com");
    }
}
