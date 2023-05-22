

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/KA20463902/eclipse-workspace/cucumber_selenium/src/test/java/Features"
		,glue = {"bindings"}
		,tags = "@petstore"
		,plugin = {"pretty","html:petstore_Ques1_Target/HtmlReports/petstoreReport.html",
						"pretty","junit:petstore_Ques1_Target/JunitReports/petstoreReport.xml",
						"pretty","json:petstore_Ques1_Target/JsonReports/petstoreReport.json"}
		)

@Test
public class petstore_Ques1_Runner extends AbstractTestNGCucumberTests {

}
