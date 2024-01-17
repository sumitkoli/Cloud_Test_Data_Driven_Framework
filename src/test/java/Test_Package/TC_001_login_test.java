package Test_Package;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_Package.Base_Class;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import util.DataUtil;
import util.HelperClass;
import util.MyXLSReader;

public class TC_001_login_test extends Base_Class {

	WebDriver driver;
	MyXLSReader excelReader;

	@Test(dataProvider = "datafor_login")
	public void test_login(HashMap<String, String> hMap) {

		if (!DataUtil.isRunnable(excelReader, "LoginTest", "TestCases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Run mode is set to N, hence not executed");
		}

		driver = openBrowser(hMap.get("Browser"));

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserEmail(hMap.get("Username"));

		loginPage.enterUserPassword(hMap.get("Password"));

		HomePage homePage = loginPage.clickonSignInButton();

		HelperClass helperClass = new HelperClass();
		helperClass.assertvalidation(hMap.get("ExpectedResult"), homePage.verifyWelcomeText());
	}

	@DataProvider
	public Object[][] datafor_login() {

		Object[][] data = null;
		try {
			excelReader = new MyXLSReader("src\\test\\resources\\TutorialsNinja.xlsx");

			data = DataUtil.getTestData(excelReader, "LoginTest", "Data");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return data;
		
	}
}
