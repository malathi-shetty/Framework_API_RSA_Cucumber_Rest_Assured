package cucumber.Options;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = {"stepDefinitions"},
    	//	 tags = "@AddPlace",  // Single tag
 //   tags="@Regression",
    	//	tags = "@DeletePlace", // compile test verify
   // tags = "@AddPlace and @DeletePlace",  // Multiple tags using logical operator
    plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json", "json:target/jsonReports/cucumber-report.json"}
)
public class TestRunner {
	
	  @Test
	    public void simpleTest() {
	        assertTrue(true);
}
}