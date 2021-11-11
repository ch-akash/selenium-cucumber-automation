package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        glue = {"steps", "hooks"},
        tags = "@browser")
public class CucumberRunner extends AbstractTestNGCucumberTests {


}
