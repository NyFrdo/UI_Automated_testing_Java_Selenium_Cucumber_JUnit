package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {
                "src/test/resources/features/test.feature",
        },

        glue={"stepDefinition" },
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json" },
//        format
        strict=true
)

@RunWith(Cucumber.class)
public class webRunner {

}
