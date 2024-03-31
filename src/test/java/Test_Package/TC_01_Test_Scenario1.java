package Test_Package;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_Test_Scenario1 {

	WebDriver driver;

	// String Generator
	public String generateRandomChars(String candidateChars, int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
		}

		return sb.toString();
	}

	// invoice Number Generator
	public String generateInvoiceNumber() {

		String invoiceNumberGenerator = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		int invoiceNumberLength = 10;
		String invoice_Length = generateRandomChars(invoiceNumberGenerator, invoiceNumberLength);

		return invoice_Length;
	}

	@Test
	public void test_01() throws InterruptedException {
		String invoice_number = generateInvoiceNumber();

		// System.setProperty("webdriver.chrome.driver", "C:/<full
		// path>/chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().driverVersion("121.0.6167.184").setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://bodhavaji.disctesting.in/#/session/signin");

		// Login
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("PKASO");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("8550998862");
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root "
				+ "MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-"
				+ "containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary "
				+ "MuiButton-sizeMedium MuiButton-containedSizeMedium css-1usxxvf']")).click();

		// Test
		// Click on Stock Inward
		driver.findElement(By.xpath("//span[contains(text(),'Stock Inward')]")).click();
		// Click on Add New Stock
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-"
				+ "root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium "
				+ "MuiButton-outlinedSizeMedium MuiButton-root MuiButton-outlined MuiButton-"
				+ "outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium rightalign_" + "btn css-gwitx9']"))
				.click();

		// Supplier Field
		WebElement supplier = driver.findElement(By.xpath("//input[@name='supplierId']"));

		supplier.sendKeys("Sunil TK");
		supplier.sendKeys(Keys.DOWN);
		supplier.sendKeys(Keys.ENTER);
		supplier.click();
		supplier.sendKeys(Keys.DOWN);
		supplier.sendKeys(Keys.ENTER);

		// Yard Field
		WebElement yard = driver.findElement(By.xpath("//input[@name='Yard']"));
		yard.sendKeys("AUG");
		yard.sendKeys(Keys.DOWN);
		yard.sendKeys(Keys.ENTER);

		// Invoice Date
		WebElement invoice_Date = driver.findElement(By.xpath("//input[@name='invoice_date']"));
		invoice_Date.sendKeys("20022024");

		// Product Group
		WebElement product_Group = driver.findElement(By.xpath("//input[@name='SKU']"));
		product_Group.sendKeys("GC");
		product_Group.sendKeys(Keys.DOWN);
		product_Group.sendKeys(Keys.ENTER);

		// Invoice Number
		driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(invoice_number);

		// Remark
		driver.findElement(By.id("remark")).sendKeys("Test Remark");

		// Vehicle number
		driver.findElement(By.xpath("//input[@name='vehical_number']")).sendKeys("MH03JH2343");

		// Truck Arrived from
		driver.findElement(By.xpath("//input[@name='truckArrivedFrom']")).sendKeys("Mumbai");

		// Truck Name
		driver.findElement(By.xpath("//input[@name='truckNo']")).sendKeys("Tata Truck");

		// invoice net Weight
		driver.findElement(By.xpath("//input[@name='truckWeight']")).sendKeys("600");

		// Add Item
		driver.findElement(By.xpath("//button[contains(text(),'Add Item')]")).click();

		// Item 1
		WebElement thickness1 = driver.findElement(By.xpath("//input[@id='mui-11']"));
		thickness1.sendKeys("0.25");
		thickness1.sendKeys(Keys.DOWN);
		thickness1.sendKeys(Keys.ENTER);

		WebElement width1 = driver.findElement(By.xpath("//input[@id='mui-13']"));
		width1.sendKeys("1220");
		width1.sendKeys(Keys.DOWN);
		width1.sendKeys(Keys.ENTER);

		WebElement length1 = driver.findElement(By.xpath("//input[@id='mui-15']"));
		length1.sendKeys("3050");
		length1.sendKeys(Keys.DOWN);
		length1.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='InwardQuantity_0']")).sendKeys("200");

		driver.findElement(By.xpath("//input[@name='InwardWeight_0']")).sendKeys("200");

		// Item 2
		// Add Item
		driver.findElement(By.xpath("//button[contains(text(),'Add Item')]")).click();

		WebElement thickness2 = driver.findElement(By.xpath("//input[@id='mui-17']"));
		thickness2.sendKeys("0.30");
		thickness2.sendKeys(Keys.DOWN);
		thickness2.sendKeys(Keys.ENTER);

		WebElement width2 = driver.findElement(By.xpath("//input[@id='mui-19']"));
		width2.sendKeys("1220");
		width2.sendKeys(Keys.DOWN);
		width2.sendKeys(Keys.ENTER);

		WebElement length2 = driver.findElement(By.xpath("//input[@id='mui-21']"));
		length2.sendKeys("3050");
		length2.sendKeys(Keys.DOWN);
		length2.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='InwardQuantity_1']")).sendKeys("200");

		driver.findElement(By.xpath("//input[@name='InwardWeight_1']")).sendKeys("200");

		// Item
		// Add Item 3
		driver.findElement(By.xpath("//button[contains(text(),'Add Item')]")).click();

		WebElement thickness3 = driver.findElement(By.xpath("//input[@id='mui-23']"));
		thickness3.sendKeys("0.35");
		thickness3.sendKeys(Keys.DOWN);
		thickness3.sendKeys(Keys.ENTER);

		WebElement width3 = driver.findElement(By.xpath("//input[@id='mui-25']"));
		width3.sendKeys("1220");
		width3.sendKeys(Keys.DOWN);
		width3.sendKeys(Keys.ENTER);

		WebElement length3 = driver.findElement(By.xpath("//input[@id='mui-27']"));
		length3.sendKeys("3050");
		length3.sendKeys(Keys.DOWN);
		length3.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='InwardQuantity_2']")).sendKeys("200");

		driver.findElement(By.xpath("//input[@name='InwardWeight_2']")).sendKeys("200");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr[2]/td[7]/button[1]")).click();
		Thread.sleep(3000);
		// Item
		// Add Item 4
		driver.findElement(By.xpath("//button[contains(text(),'Add Item')]")).click();

		WebElement thickness4 = driver.findElement(By.xpath("//input[@id='mui-29']"));
		thickness4.sendKeys("0.30");
		thickness4.sendKeys(Keys.DOWN);
		thickness4.sendKeys(Keys.ENTER);

		WebElement width4 = driver.findElement(By.xpath("//input[@id='mui-31']"));
		width4.sendKeys("1220");
		width4.sendKeys(Keys.DOWN);
		width4.sendKeys(Keys.ENTER);

		WebElement length4 = driver.findElement(By.xpath("//input[@id='mui-33']"));
		length4.sendKeys("3050");
		length4.sendKeys(Keys.DOWN);
		length4.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='InwardQuantity_2']")).sendKeys("200");

		driver.findElement(By.xpath("//input[@name='InwardWeight_2']")).sendKeys("200");

		// Click on Save Button
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

		// Click on OK Button
		driver.findElement(By.xpath("//a[contains(text(),'OK')]")).click();

		// Next Page // Add Batch1
		driver.findElement(By.xpath("//tbody/tr[1]/td[6]/button[1]")).click();

		// Add Batch1 P1
		driver.findElement(By.xpath("//button[contains(text(),'Add Item')]")).click();
		driver.findElement(By.xpath("//input[@name='batchNo_0']")).sendKeys(generateInvoiceNumber());

		WebElement zone11 = driver.findElement(By.xpath("//input[@name='zoneId_0']"));
		zone11.sendKeys("AUG");
		zone11.sendKeys(Keys.DOWN);
		zone11.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='InwardQuantity_0']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@name='InwardWeight_0']")).sendKeys("100");

		// Add Batch2 P2
		driver.findElement(By.xpath("//button[contains(text(),'Add Item')]")).click();
		driver.findElement(By.xpath("//input[@name='batchNo_1']")).sendKeys(generateInvoiceNumber());

		WebElement zone12 = driver.findElement(By.xpath("//input[@name='zoneId_1']"));
		zone12.sendKeys("AUG");
		zone12.sendKeys(Keys.DOWN);
		zone12.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='InwardQuantity_1']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@name='InwardWeight_1']")).sendKeys("100");

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

		// Click on OK Button
		driver.findElement(By.xpath("//a[contains(text(),'OK')]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Back to StockInward')]")).sendKeys(Keys.PAGE_DOWN);

		Thread.sleep(2000);

		// Add Batch2
		driver.findElement(By.xpath("//button[contains(text(),'Add Batches')]")).click();
		// Add Batch2 P1
		driver.findElement(By.xpath("//button[contains(text(),'Add Item')]")).click();
		driver.findElement(By.xpath("//input[@name='batchNo_0']")).sendKeys(generateInvoiceNumber());

		WebElement zone21 = driver.findElement(By.xpath("//input[@name='zoneId_0']"));
		zone21.sendKeys("AUG");
		zone21.sendKeys(Keys.DOWN);
		zone21.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='InwardQuantity_0']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@name='InwardWeight_0']")).sendKeys("100");

		// Add Batch2 P2
		driver.findElement(By.xpath("//button[contains(text(),'Add Item')]")).click();
		driver.findElement(By.xpath("//input[@name='batchNo_1']")).sendKeys(generateInvoiceNumber());

		WebElement zone22 = driver.findElement(By.xpath("//input[@name='zoneId_1']"));
		zone22.sendKeys("AUG");
		zone22.sendKeys(Keys.DOWN);
		zone22.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='InwardQuantity_1']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@name='InwardWeight_1']")).sendKeys("100");

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

		// Click on OK Button
		driver.findElement(By.xpath("//a[contains(text(),'OK')]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Back to StockInward')]")).sendKeys(Keys.PAGE_DOWN);

		Thread.sleep(3000);
		// Add Batch3
		driver.findElement(By.xpath("//button[contains(text(),'Add Batches')]")).click();

		// Add Batch3 P1
		driver.findElement(By.xpath("//button[contains(text(),'Add Item')]")).click();
		driver.findElement(By.xpath("//input[@name='batchNo_0']")).sendKeys(generateInvoiceNumber());

		WebElement zone31 = driver.findElement(By.xpath("//input[@name='zoneId_0']"));
		zone31.sendKeys("AUG");
		zone31.sendKeys(Keys.DOWN);
		zone31.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='InwardQuantity_0']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@name='InwardWeight_0']")).sendKeys("100");

		// Add Batch3 P2
		driver.findElement(By.xpath("//button[contains(text(),'Add Item')]")).click();
		driver.findElement(By.xpath("//input[@name='batchNo_1']")).sendKeys(generateInvoiceNumber());

		WebElement zone32 = driver.findElement(By.xpath("//input[@name='zoneId_1']"));
		zone32.sendKeys("AUG");
		zone32.sendKeys(Keys.DOWN);
		zone32.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='InwardQuantity_1']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@name='InwardWeight_1']")).sendKeys("100");

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

		// Click on OK Button
		driver.findElement(By.xpath("//a[contains(text(),'OK')]")).click();

		// ______-------------------------------------------------------------

		// View Stock
		driver.findElement(By.xpath("//span[contains(text(),'View Stock')]")).click();

		// Product Group
		WebElement product_Group1 = driver.findElement(By.xpath("//input[@name='skuTypeId']"));
		product_Group1.sendKeys("GC");
		product_Group1.sendKeys(Keys.DOWN);
		product_Group1.sendKeys(Keys.ENTER);

		//SKU
		WebElement sku1 = driver.findElement(By.xpath("//input[@name='skuId']"));

		sku1.sendKeys("0.25");
		sku1.sendKeys(Keys.DOWN);
		sku1.sendKeys(Keys.ENTER);

		sku1.sendKeys("0.30");
		sku1.sendKeys(Keys.DOWN);
		sku1.sendKeys(Keys.ENTER);

		sku1.sendKeys("0.35");
		sku1.sendKeys(Keys.DOWN);
		sku1.sendKeys(Keys.ENTER);

		//Yard
		WebElement yard1 = driver.findElement(By.xpath("//input[@name='yardId']"));

		yard1.sendKeys("AU");
		yard1.sendKeys(Keys.DOWN);
		yard1.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//button[contains(text(),'Go')]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Go')]")).sendKeys(Keys.PAGE_DOWN);

		
		
	}
}
