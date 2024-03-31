package Test_Package;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.DataUtil;
import util.MyXLSReader;

public class SampleTest {
 WebDriver driver;
 MyXLSReader reader;
	
	@Test(dataProvider="dataprovider1")
	public void dataDriven(HashMap<String, String> hmap) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("Test Login");
		
		driver.findElement(By.id("UserId")).sendKeys(hmap.get("Username"));
		
		driver.findElement(By.id("Password")).sendKeys(hmap.get("password"));
		
		driver.findElement(By.id("Loginbtn")).click();
	}
	
	@DataProvider
	public Object dataprovider1() {
		
		Object data=null;
		
		try {
			reader=new MyXLSReader("//File//Path");
			data=DataUtil.getTestData(reader, "Login Test", "Data");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	
}
