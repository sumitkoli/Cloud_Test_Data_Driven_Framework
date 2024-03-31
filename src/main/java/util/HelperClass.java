package util;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class HelperClass {
	public Logger log = LogManager.getLogger("Logs");
	MyXLSReader excelReader;

	// Assert Validation
	public void assertvalidation(String expectedString, boolean actualresult) {

		String expectedResult = expectedString;// hMap.get("ExpectedResult")

		boolean expectedConvertedResult = false;

		if (expectedResult.equalsIgnoreCase("Success")) {
			expectedConvertedResult = true;
		} else if (expectedResult.equalsIgnoreCase("Failure")) {
			expectedConvertedResult = false;
		}

		boolean actualResult = false;

		actualResult = actualresult; // homePage.verifyWelcomeText();

		Assert.assertEquals(actualResult, expectedConvertedResult);
		log.info("Login Test Validation Passed");
	}

	// String Generator
	public String generateRandomChars(String candidateChars, int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
		}

		return sb.toString();
	}

	// Email String Generator
	public String generateEmailString() {

		String emailGenerator = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		int emaillength =6;
		String emailData = generateRandomChars(emailGenerator, emaillength) + "@gmail.com";

		return emailData;
	}

	// Mobile Number String Generator
	public String generateMobileNumberString() {

		String mobilenumberGenrator = "1234567890";
		int mobileNumberlength = 6;
		String mobileData = generateRandomChars(mobilenumberGenrator, mobileNumberlength);

		return mobileData;
	}

	public void addexcelvalueDetailstoExtendReport() {
		
	}

}
