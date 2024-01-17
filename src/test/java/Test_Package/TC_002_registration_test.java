package Test_Package;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_Package.Base_Class;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import util.DataUtil;
import util.HelperClass;
import util.MyXLSReader;

public class TC_002_registration_test extends Base_Class {

	WebDriver driver;
	MyXLSReader excelReader;
	HelperClass helperClass = new HelperClass();

	@Test(dataProvider = "datafor_Registration")
	public void registration_test(HashMap<String, String> hMap) {

		if (!DataUtil.isRunnable(excelReader, "RegistrationTest", "TestCases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Run mode is set to N, hence not executed");
		}

		driver = openBrowser(hMap.get("Browser"));

		LoginPage loginPage = new LoginPage(driver);
		RegistrationPage registrationPage = loginPage.clickonSignupLink();

		registrationPage.enterFirstname(hMap.get("FirstName"));
		registrationPage.enterLastname(hMap.get("LastName"));
		registrationPage
				.enteruserMobileNo(hMap.get("MobileNo").replaceAll("a", "") + helperClass.generateMobileNumberString());
		registrationPage.enteruserEmail(hMap.get("Email") + helperClass.generateEmailString());
		registrationPage.enteruserPassword(hMap.get("UserPassword").replaceAll("a", ""));
		registrationPage.clickonSigninButton();

		helperClass.assertvalidation(hMap.get("ExpectedResult"), registrationPage.verifyRegistrationText());

	}

	@DataProvider
	public Object[][] datafor_Registration() {

		Object[][] data = null;
		try {
			excelReader = new MyXLSReader("src\\test\\resources\\TutorialsNinja.xlsx");

			data = DataUtil.getTestData(excelReader, "RegistrationTest", "Data");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return data;
	}
}
