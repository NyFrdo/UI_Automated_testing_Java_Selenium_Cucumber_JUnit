import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import sun.security.mscapi.PRNG;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

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
public class Login {
}