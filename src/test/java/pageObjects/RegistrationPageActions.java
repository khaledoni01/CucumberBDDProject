package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageLocators.LogInPageLocators;
import pageLocators.RegistrationPageLocators;
import runners.RunCucumberTest;
import stepDef.TestBase;


public class RegistrationPageActions {

	private WebDriver driver = null;
	private TestBase tb = null;
	private RegistrationPageLocators registrationPageLocators = null;
	
	public RegistrationPageActions(WebDriver driver) {
		this.driver = driver;
		this.registrationPageLocators = new RegistrationPageLocators();
		PageFactory.initElements(driver, this.registrationPageLocators);
	}

	public TestBase tbObject() {
		if(this.tb == null) {
			this.tb = new TestBase();
		}
		return this.tb;
	}
	
	public RegistrationPageActions provideRegInfo(String firstName, String lastName, String email, String regPassWord,
													String month, String day, String year) {
		
		this.tbObject().commonUtilObject().waitDriverUntilElementIsVisible(this.driver, this.registrationPageLocators.createAcctBtn);
		this.tbObject().commonUtilObject().clickEle(this.registrationPageLocators.createAcctBtn);
//		TestListener.extentTest.get().log(LogStatus.INFO, "Create Account button is clicked");
		
		this.tbObject().commonUtilObject().waitDriverUntilElementIsVisible(this.driver, this.registrationPageLocators.firstName);
		this.tbObject().commonUtilObject().inputKeysToEle(this.registrationPageLocators.firstName, firstName);
		this.tbObject().commonUtilObject().inputKeysToEle(this.registrationPageLocators.lastName, lastName);
		this.tbObject().commonUtilObject().inputKeysToEle(this.registrationPageLocators.email, email);
		this.tbObject().commonUtilObject().inputKeysToEle(this.registrationPageLocators.regPassWord, regPassWord);
		
		this.tbObject().commonUtilObject().selectEleFromDropDown(this.registrationPageLocators.month).selectByVisibleText(month);
		this.tbObject().commonUtilObject().selectEleFromDropDown(this.registrationPageLocators.day).selectByVisibleText(day);
		this.tbObject().commonUtilObject().selectEleFromDropDown(this.registrationPageLocators.year).selectByVisibleText(year);
		this.tbObject().commonUtilObject().clickEle(this.registrationPageLocators.gender.get(0));
		
//		TestListener.extentTest.get().log(LogStatus.INFO, "Registration details have been provided");
		
		return this;
	}
			

}
