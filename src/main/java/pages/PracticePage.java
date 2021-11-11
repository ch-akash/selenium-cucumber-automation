package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertyUtil;

import java.util.List;

public class PracticePage extends BasePage {

    @FindBy(css = "input[name='radioButton']")
    private List<WebElement> radioButtons;

    @FindBy(css = "input[value='radio1']")
    private WebElement radioButton1;

    private String iFrameId = "courses-iframe";

    public PracticePage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getRadioButtons() {
        waitForElementVisibility(radioButton1);
        return radioButtons;
    }

    public void switchToFrame() {
        this.waitForElementVisibility(radioButton1);
        this.driver.switchTo().frame(iFrameId);
    }

    public WebElement selectProductFromTable(String productDescription) {
        By productLocator = By.xpath(String.format("//td[text()='%s']", productDescription));
        this.waitForElementVisibility(productLocator);
        return this.driver.findElement(productLocator);
    }

    @SneakyThrows
    public void open() {
        this.driver.get(PropertyUtil.getPropertyValue("practice.page.url", "test.properties"));
    }
}
