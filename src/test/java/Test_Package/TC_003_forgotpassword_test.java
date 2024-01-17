package Test_Package;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_Package.Base_Class;
import pageobjects.ForgotPasswordPage;
import pageobjects.LoginPage;
import util.DataUtil;
import util.HelperClass;
import util.MyXLSReader;

public class TC_003_forgotpassword_test extends Base_Class {

	WebDriver driver;
	MyXLSReader excelReader;
	HelperClass helperClass = new HelperClass();

	@Test(dataProvider = "datafor_forgotPassword")
	public void test_forgotPassword(HashMap<String, String> hMap) {
		if (!DataUtil.isRunnable(excelReader, "ForgotPasswordTest", "TestCases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Run mode is set to N, hence not executed");
		}

		driver = openBrowser(hMap.get("Browser"));

		LoginPage loginPage = new LoginPage(driver);
		ForgotPasswordPage forgotPasswordPage = loginPage.clickonForgotPasswordLink();

		forgotPasswordPage.enterParentEmail(hMap.get("Email"));
		forgotPasswordPage.clickonSendEmailButton();
		System.out.println(driver.getTitle());

		helperClass.assertvalidation(hMap.get("ExpectedResult"), loginPage.verifyForgetPasswordtext());

	}

	@DataProvider
	public Object[][] datafor_forgotPassword() {

		Object[][] data = null;
		try {
			excelReader = new MyXLSReader("src\\test\\resources\\TutorialsNinja.xlsx");

			data = DataUtil.getTestData(excelReader, "ForgotPasswordTest", "Data");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return data;
	}

}
