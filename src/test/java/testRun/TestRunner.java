package testRun;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		// features = ".\\Features\\login.feature",
		features = ".\\Features\\login_tagexample.feature", // for tags example
		glue = "steps", monochrome = true, plugin = { "pretty", "html:test-output" },
		// plugin = { "pretty", "html:test-output", "json:target/cucumber-report.json"
		// }, // to create json file under target
		tags = { "@RegressionTest" }

)

public class TestRunner {

}
