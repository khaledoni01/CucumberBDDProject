package stepDef;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageTest extends TestBase {
	
	@Given("^user has landed on Facebook login page$")
	public void user_has_landed_on_Facebook_login_page() {
		
		System.out.println("FB landing page before login");
		Assert.assertEquals(TestBase.getDriver().getCurrentUrl(), "https://www.facebook.com");		
	}
	
	@When("^user provides facebook login credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_provides_facebook_login_credentials(String username, String password) {
					
		logInPageActions.loginFbUser(username, password);			
	}


	@Then("^user should be able to login$")
	public void user_should_be_able_to_login(String username, String password) {
		
		System.out.println("FB home page after login");
		Assert.assertEquals(TestBase.getDriver().getCurrentUrl(), "https://www.facebook.com");		
					
	}

    

}
