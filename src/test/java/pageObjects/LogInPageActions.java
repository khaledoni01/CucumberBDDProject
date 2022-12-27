package pageObjects;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import pageLocators.LogInPageLocators;
import stepDef.TestBase;
import testUtil.CommonUtil;
import testUtil.Utility;

public class LogInPageActions {
	
	// Every test action class needs to have followings:
	// 1. variables: driver, testBase, locatorClass
	// 2. methods: testBase_return and corresponding test methods
	// 3. every test method may/may not return current object

	private WebDriver driver = null;
	private TestBase tb = null;
	private LogInPageLocators logInPageLocators = null;
	
	public LogInPageActions(WebDriver driver) {
		this.driver = driver;
		this.logInPageLocators = new LogInPageLocators();
		PageFactory.initElements(driver, this.logInPageLocators);
	}

	public TestBase tbObject() {
		if(this.tb == null) {
			this.tb = new TestBase();
		}
		return this.tb;
	}
	
	public LogInPageActions loginFbUser(String userName, String passWord) {
		this.tbObject().commonUtilObject().waitDriverUntilElementIsVisible(this.driver, this.logInPageLocators.userName);
		
		this.tbObject().commonUtilObject().inputKeysToEle(this.logInPageLocators.userName, userName);
		this.tbObject().commonUtilObject().inputKeysToEle(this.logInPageLocators.passWord, passWord);
//		TestListener.extentTest.get().log(LogStatus.INFO, "Login info. is provided");		
		
		return this;
	}
		
	public void assertionFalse() {
		Assert.assertTrue(false);
	}
	
	public LogInPageActions fbRegistration(String firstName, String lastName, String email, 
								String regPassWord, String month, String day, String year) {
		
		this.tbObject().registrationPageActionsObject(this.driver)
		.provideRegInfo(firstName, lastName, email, regPassWord, month, day, year);
		return this;
	}	
	
	public LogInPageActions accessCommonClassMethod() {
		this.tbObject().commonClassObject().commonMethod();
		return this;
	}
	public LogInPageActions accessCommonClassVar() {
		this.tbObject().commonClassObject().setcVar("Common Variable");
		return this;
	}
	
	

}
