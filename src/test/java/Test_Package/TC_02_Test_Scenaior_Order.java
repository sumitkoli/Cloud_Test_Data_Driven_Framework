package Test_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_02_Test_Scenaior_Order {
	WebDriver driver;

	@Test
	public void test_order() throws InterruptedException {

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
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

		// Order Page

		driver.findElement(By.xpath("//a//span[contains(text(),'Order')]")).click();
		// Add New Order
		driver.findElement(By.xpath("//button[contains(text(),'Add New Order')]")).click();
		// Customer
		WebElement customer = driver.findElement(By.xpath("//input[@name='Daeler_customer']"));
		customer.sendKeys("A");
		customer.sendKeys(Keys.DOWN);
		customer.sendKeys(Keys.ENTER);

		// Product Group
		WebElement product = driver.findElement(By.xpath("//input[@name='SKU']"));
		product.sendKeys("GC");
		product.sendKeys(Keys.DOWN);
		product.sendKeys(Keys.ENTER);

		// Remark
		driver.findElement(By.id("remark")).sendKeys("Test Remark");

		// BM
		WebElement bm = driver.findElement(By.xpath("//input[@name='BM']"));
		bm.sendKeys("Pavan");
		bm.sendKeys(Keys.DOWN);
		bm.sendKeys(Keys.ENTER);

		// Yard Field
		WebElement yard = driver.findElement(By.xpath("//input[@name='Yard']"));
		yard.sendKeys("AUG");
		yard.sendKeys(Keys.DOWN);
		yard.sendKeys(Keys.ENTER);

		//Wrong SKU Data
		driver.findElement(By.xpath("//input[@name='qtypcs_0']")).sendKeys("6000");

		driver.findElement(By.xpath("//input[@name='qtypcs_1']")).sendKeys("3000");

		driver.findElement(By.xpath("//input[@name='qtypcs_2']")).sendKeys("2000");

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'OK')]")).click();

		
		//SKU Correct Data
		driver.findElement(By.xpath("//input[@name='qtypcs_0']")).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@name='qtypcs_0']")).sendKeys("200");
		driver.findElement(By.xpath("//input[@name='checked_0']")).click();
		
		driver.findElement(By.xpath("//input[@name='qtypcs_1']")).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@name='qtypcs_1']")).sendKeys("200");
		driver.findElement(By.xpath("//input[@name='checked_1']")).click();
		
		driver.findElement(By.xpath("//input[@name='qtypcs_2']")).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@name='qtypcs_2']")).sendKeys("200");
		driver.findElement(By.xpath("//input[@name='checked_2']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'OK')]")).click();
		Thread.sleep(3000);
		
		//Edit 
		driver.findElement(By.xpath("//tbody/tr[1]/td[10]/iconbutton[1]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Back to Order')]")).sendKeys(Keys.DOWN);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr[2]/td[13]/button[1]/span[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='qtypcs']")).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='qtypcs']")).sendKeys("150");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='qtypcs']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Send For Approval')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'OK')]")).click();
		
		//View
		driver.findElement(By.xpath("//a//span[contains(text(),'Order')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//icon[contains(text(),'remove_red_eye')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Back to Order')]")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//a[contains(text(),'SKU 0.25 X 1220 X 10')]")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//a[contains(text(),'SKU 0.25 X 1220 X 10')]")).sendKeys(Keys.DOWN);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'SKU 0.25 X 1220 X 10')]")).sendKeys(Keys.UP);
		
		driver.findElement(By.xpath("//button[contains(text(),'Back to Order')]")).click();
	}
}
