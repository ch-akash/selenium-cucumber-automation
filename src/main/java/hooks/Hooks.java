package hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.Source;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    @After(value = "@browser")
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) this.stepContext.webDriver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failure_image");
        }
    }

    @After
    public void after() {
        if (Objects.nonNull(this.stepContext.webDriver)) {
            this.stepContext.webDriver.quit();
        }
    }
}
