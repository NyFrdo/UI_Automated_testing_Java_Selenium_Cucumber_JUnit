import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {
                "src/test/resources/features/test.feature",
        },

        glue={"hk.org.java" },
        plugin = { "hk.org.ha.qa.cucumber.formatter.TestFormatter" },
        monochrome = true,
        strict=true
)

@RunWith(CustomizedCucumber.class)
public class WebRunner {
}