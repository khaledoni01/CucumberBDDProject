package stepDef;

import io.cucumber.java.en.When;

public class LoginPageTest2 {
		
	
	@When("^user provides facebook registration details$")
	public void user_provides_facebook_registration_details() {
		TestBase.logInPageActions.get()
		.tbObject().registrationPageActionsObject(TestBase.getDriver())
		.provideRegInfo("firstName", "lastName", "email", "regPassWord", "Feb", "10", "2000")
		.tbObject().commonClassObject().commonMethod();		
	}

}
