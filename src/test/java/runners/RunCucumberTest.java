package runners;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import testUtil.FeaturesOverride;
import testUtil.Utility;

@CucumberOptions(
		plugin = {"pretty", 
				"html:target/cucumber-report",
				"json:target/cucumber.json", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		features = {"src/test/java/FeatureFiles/"},
		glue = {"stepDef"},
		tags = {"@sanity"}, // "@sanity or @feature" "@sanity and @feature"
		monochrome = true,
		strict = false,
		dryRun = false
)
public class RunCucumberTest extends AbstractTestNGCucumberTests{
	
	@BeforeSuite
	public void beforeSuite() {
		FeaturesOverride feat = new FeaturesOverride();
		Utility util = new Utility();
		feat.overrideAllFiles(util.getFeatureFilePath(), util.getExcelBasePath());
	}
	
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
	
	
}
