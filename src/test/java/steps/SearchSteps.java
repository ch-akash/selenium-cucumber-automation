package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import sharedObjects.StepContext;

public class SearchSteps {

    private final HomePage homePage;

    public SearchSteps(StepContext stepContext) {
        this.homePage = new HomePage(stepContext.webDriver);
    }

    @When("user opens google home page")
    public void userOpensGoogleHomePage() {
        this.homePage.open();
    }

    @Then("search for {string}")
    public void searchFor(String arg0) {
        this.homePage.searchForKeyword(arg0);
    }

}
