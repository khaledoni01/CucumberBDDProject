package runners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import stepDef.TestBase;

@CucumberOptions(
		plugin = {"pretty", 
				"html:target/cucumber-report",
				"json:target/cucumber.json"
				},
		features = {"src/test/java/FeatureFiles/"},
		glue = {"stepDef"},
		monochrome = true
		
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
	
//	@BeforeSuite
//	public void beforeSuite() {
//		// you can have launch browser 
//		// but currently we're launching browser before every scenarios
//		
//		System.out.println("Before Suite");
//	}
//	
//    @Override
//    @DataProvider()
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//    
//    @AfterSuite()
//    public void afterSuite() {
//    	System.out.println("After Suite");
//    }
	
	
}
