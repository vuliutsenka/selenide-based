package tests.cucumber;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberReport.json",

        },
        features = "src/test/resources/features/first.feature",
        tags = {"@ExampleTag"},
        glue = "stepdefinitions"
)
public class CucumberTest extends BaseCucumberTest {
}
