package lanit.testExecution;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "lanit.testExecution",
        tags = "@myDocuments",
        dryRun = false,
        strict = false,
        snippets = SnippetType.UNDERSCORE,
        plugin = { "json:target/test-report.json" }
)
public class CucumberRunner {
}