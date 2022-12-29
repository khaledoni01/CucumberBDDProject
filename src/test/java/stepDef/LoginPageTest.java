package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPageTest extends TestBase {
	
	@Given("^user has landed on Facebook login page$")
	public void user_has_landed_on_Facebook_login_page() {
		
		System.out.println("FB Landing Page");
	}
	
	@When("^user provides facebook login credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_provides_facebook_login_credentials(String username, String password) {
					
		logInPageActions.loginFbUser(username, password);			
	}
		
}
