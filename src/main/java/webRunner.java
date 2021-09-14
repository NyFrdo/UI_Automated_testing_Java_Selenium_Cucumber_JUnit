import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {
                "src/test/resources/features/test.feature",
        },

        glue={"hk.org.java" },
        monochrome = true,
        strict=true
)

@RunWith(Cucumber.class)
public class webRunner {

}
