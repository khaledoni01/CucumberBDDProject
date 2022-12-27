package pageLocators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogInPageLocators {

	@FindBy(id="email")
	public WebElement userName;

	@FindBy(id="pass")
	public WebElement passWord;

	

	
	
}
