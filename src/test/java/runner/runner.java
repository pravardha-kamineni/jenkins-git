package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/KA20463902/eclipse-workspace/cucumberselenium/src/test/java/Features"
		,glue = {"bindings"}
		,tags = "@Signin"
		,dryRun = true
		,monochrome = true
		,plugin = {"pretty","html:target/HtmlReports/report1.html",
				"pretty","junit:target/JunitReports/report1.xml",
				"pretty","json:target/JsonReports/report1.xml"}
		)


public class runner {

}
