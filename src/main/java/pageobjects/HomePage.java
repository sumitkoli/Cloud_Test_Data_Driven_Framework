package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//-----------------------------------WebElement-----------------------------------------
	
		
	//WebElement Welcome Verify Text
	@FindBy(xpath = "//h3[contains(text(),'Welcome')]")
	private WebElement welcomeverifyText;

	//------------------------------------Methods----------------------------------------------
	
		
	//Welcome Text
	public boolean verifyWelcomeText() {
		boolean displayStatus = false;
		try {
			displayStatus = welcomeverifyText.isDisplayed();
		} catch (Throwable e) {
			displayStatus = false;
		}
		return displayStatus;
	}
}
