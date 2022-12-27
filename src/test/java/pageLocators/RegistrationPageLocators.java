package pageLocators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageLocators {
	
	
	@FindBy(xpath="//a[contains(text(), 'Create New Account')]")
	public WebElement createAcctBtn;
	
	@FindBy(xpath="//input[@name='firstname']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	public WebElement email;
	
	@FindBy(xpath="//input[@name='reg_passwd__']")
	public WebElement regPassWord;
	
	@FindBy(xpath="//select[@id='month']")
	public WebElement month;
	
	@FindBy(xpath="//select[@id='day']")
	public WebElement day;
	
	@FindBy(xpath="//select[@id='year']")
	public WebElement year;
	
	@FindBy(xpath="//input[@type='radio']")
	public List<WebElement> gender;

}
