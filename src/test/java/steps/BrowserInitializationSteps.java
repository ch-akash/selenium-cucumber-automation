package steps;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import sharedObjects.StepContext;

public class BrowserInitializationSteps {

    private StepContext stepContext;

    public BrowserInitializationSteps(StepContext context) {
        this.stepContext = context;
    }
}
