package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageLocators.LogInPageLocators;
import stepDef.TestBase;

public class LogInPageActions {	

	public LogInPageLocators logInPageLocators = null;
	
	public LogInPageActions() {
		this.logInPageLocators = new LogInPageLocators();
		PageFactory.initElements(TestBase.getDriver(), this.logInPageLocators);
	}
	
	public void loginFbUser(String userName, String passWord) {
		
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(this.logInPageLocators.userName));
		
		this.logInPageLocators.userName.sendKeys(userName);
		this.logInPageLocators.passWord.sendKeys(passWord);
	}
		
	

}
