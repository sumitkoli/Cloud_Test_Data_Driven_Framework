package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	WebDriver driver;
	public Logger log = LogManager.getLogger("Logs");

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// -----------------------------------WebElement-----------------------------------------

	// WebElement Parent Email
	@FindBy(xpath = "//input[@name=\"email\"]")
	private WebElement parentEmail;

	// WebElement Send Email Button
	@FindBy(xpath = "//button[@name=\"submit-form\"]")
	private WebElement sendEmailbutton;

	// ------------------------------------Methods----------------------------------------------

	// Enter User Parent Email
	public void enterParentEmail(String email) {
		parentEmail.sendKeys(email);
		log.info("Parent Email is entered.");
	}

	// Click on Send Email Button
	public LoginPage clickonSendEmailButton() {
		sendEmailbutton.click();
		log.info("User clicked on Send Email Button");

		return new LoginPage(driver);
	}

}
