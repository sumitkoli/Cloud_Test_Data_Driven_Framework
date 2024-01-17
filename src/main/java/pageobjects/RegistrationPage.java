package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;
	public Logger log = LogManager.getLogger("Logs");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// -----------------------------------WebElement-----------------------------------------

	// WebElement User FirstName
	@FindBy(id = "first_name")
	private WebElement firstName;

	// WebElement User LastName
	@FindBy(id = "last_name")
	private WebElement lastName;

	// WebElement User Mobile Number
	@FindBy(id = "mobile")
	private WebElement mobileNo;

	// WebElement User Email
	@FindBy(id = "email")
	private WebElement emailRegistrationPage;

	// WebElement User Password
	@FindBy(id = "password")
	private WebElement passwordRegistrationPage;

	// WebElement User Sign Up Button
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	private WebElement signUpButton;

	// WebElement Verify Registration SUccessfull Text
	@FindBy(xpath = "//div[contains(text(),'Registration successfully.')]")
	private WebElement verifyregistrationText;

	// ------------------------------------Methods----------------------------------------------

	// Enter User FirstName
	public void enterFirstname(String userfirstName) {
		firstName.sendKeys(userfirstName);
		log.info("User FirstName is entered");
	}

	// Enter User LastName
	public void enterLastname(String userlastName) {
		lastName.sendKeys(userlastName);
		log.info("User LastName is entered");
	}

	// Enter User Mobile Number
	public void enteruserMobileNo(String userMobileNo) {
		mobileNo.sendKeys(userMobileNo);
		log.info("User Mobile Number is entered");
	}

	// Enter User Email
	public void enteruserEmail(String useremail) {
		emailRegistrationPage.sendKeys(useremail);
		log.info("User email is entered");
	}

	// Enter User Password
	public void enteruserPassword(String userPassword) {
		passwordRegistrationPage.sendKeys(userPassword);
		log.info("User Password is entered");
	}

	// Click on Sign In Button
	public void clickonSigninButton() {
		signUpButton.click();
		log.info("User Clicked on Sign in button");
	}

	// verify Registration Text
	public boolean verifyRegistrationText() {
		boolean displayStatus = false;
		try {
			displayStatus = verifyregistrationText.isDisplayed();
		} catch (Throwable e) {
			displayStatus = false;
		}
		return displayStatus;
	}
}
