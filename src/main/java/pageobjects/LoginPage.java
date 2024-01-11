package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
	public Logger log=LogManager.getLogger("Logs");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//-----------------------------------WebElement-----------------------------------------
	//User Email
	@FindBy(id="email")
	private WebElement userEmail;
	
	//User Password
	@FindBy(id="password")
	private WebElement userPassword;
	
	//Sign In Button
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary']")
	private WebElement signInbutton;
	
	//Sign Up Button
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	private WebElement signUplink;
	
	//------------------------------------Methods----------------------------------------------
	
	//Enter User Email
	public void enterUserEmail(String email) {
		userEmail.sendKeys(email);
		log.info("User Email is Entered");
	}
	
	//Enter User Password
	public void enterUserPassword(String password) {
		
		userPassword.sendKeys(password);
		log.info("User Password is Entered");
	}
	
	//Click on Sign in Button
	public HomePage clickonSignInButton() {
		signInbutton.click();
		log.info("Clicked on Sign in button");
		return new HomePage(driver);
	}
	
	//Click on Sign up Link
	public RegistrationPage clickonSignupLink() {
		signUplink.click();
		log.info("Clicked on Sign up Link");
		return new RegistrationPage(driver);
		
	}
}
