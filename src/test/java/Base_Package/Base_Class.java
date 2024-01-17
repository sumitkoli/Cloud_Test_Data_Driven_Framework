package Base_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static WebDriver driver ;
	public Logger log;
	public Properties prop;
	
	
	public WebDriver openBrowser(String browser) {
		
		log=LogManager.getLogger("Logs");
		prop = new Properties();
		
		File propFile=new File("src\\test\\resources\\data.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propFile);
			prop.load(fis);
			
		} catch (Throwable e) {
			
			e.printStackTrace();
		}

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
			log.info("Chrome Browser Started Successfully");

		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(options);
			//log.info("Firefox Browser Started Successfully");

		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
			//log.info("Edge Browser Started Successfully");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));

		return driver;
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	public String capturScreenshot(String filename) {
		Date currentdate = new Date();

		String screenshotFilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		
		String destPath = null;
		
		try {
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			 File screenshotBase64 = ts.getScreenshotAs(OutputType.FILE);
			
		 destPath=".//reports//Screenshots//"+filename+screenshotFilename+".png";
		
		 File file1=new File(destPath);
		 
			FileUtils.copyFile(screenshotBase64, file1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destPath;
		
	}
	
	

}
