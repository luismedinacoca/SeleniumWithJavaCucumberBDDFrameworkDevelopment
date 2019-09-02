package TestRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/Login.feature",
        glue="step_definition",
        dryRun = true,
        monochrome = true,
        plugin = {"pretty", "html:test-output"}
)
public class TestRun {

}
