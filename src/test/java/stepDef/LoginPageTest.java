package stepDef;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testUtil.ExcelUtil;
import testUtil.Utility;

public class LoginPageTest {
	
	@Given("^user has landed on Facebook login page$")
	public void user_has_landed_on_Facebook_login_page() {
		System.out.println("FB Landing Page");
	}
	@When("^user provides facebook login credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_provides_facebook_login_credentials(String username, String password) {
		
		if(!username.equalsIgnoreCase("failed")) {
			TestBase.logInPageActions.get()
			.loginFbUser(username, password);			
		}
		else {
			TestBase.logInPageActions.get()
			.loginFbUser(username, password).assertionFalse();				
		}
	}
		
}
