package hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import sharedObjects.StepContext;

import java.util.Objects;

public class Hooks {

    private final StepContext stepContext;

    public Hooks(StepContext stepContext) {
        this.stepContext = stepContext;
    }

    @Before(value = "@browser")
    public void before() {
        stepContext.webDriver = DriverManager.getDriver();
    }


    @After
    public void after() {
        if (Objects.nonNull(this.stepContext.webDriver)) {
            this.stepContext.webDriver.quit();
        }
    }
}
