package steps;

import constants.XPathConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.PracticePage;
import pages.PracticePageFrame;
import sharedObjects.StepContext;

public class PracticePageSteps {
    private final PracticePage practicePage;
    private final PracticePageFrame practicePageFrame;
    private final StepContext stepContext;

    public PracticePageSteps(StepContext stepContext) {
        this.stepContext = stepContext;
        this.practicePageFrame = new PracticePageFrame(stepContext.webDriver);
        this.practicePage = new PracticePage(stepContext.webDriver);
    }

    @SneakyThrows
    @Given("user opens practice home page")
    public void userOpensPracticeHomePage() {
        this.practicePage.open();
    }

    @Then("click {string}st radio button")
    public void clickStRadioButton(String arg0) {
        this.practicePage.getRadioButtons().get(0).click();
    }

    @And("switch to iFrame")
    public void switchToIFrame() {
        this.practicePage.switchToFrame();
    }

    @And("click join now")
    public void clickJoinNow() {
        this.practicePageFrame.clickJoinNow();
    }

    @And("select product from table with description {string}")
    public void selectProductFromTableWithDescription(String arg0) {
        this.stepContext.selectedProductFromTable = this.practicePage.selectProductFromTable(arg0);
    }

    @Then("the product price should be {string}")
    public void theProductPriceShouldBe(String arg0) {
        Assert.assertEquals(this.stepContext.selectedProductFromTable.findElement(By.xpath(XPathConstants.FOLLOWING_SIBLING)).getText(), arg0);
    }

    @Then("the instructor name should be {string}")
    public void theInstructorNameShouldBe(String arg0) {
        Assert.assertEquals(this.stepContext.selectedProductFromTable.findElement(By.xpath(XPathConstants.PRECEDING_SIBLING)).getText(), arg0);
    }
}
