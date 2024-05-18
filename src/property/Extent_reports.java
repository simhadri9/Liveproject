package property;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent_reports {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeTest
	public void extent()
	{	
		report = new ExtentReports("./Report.Demo.html");
	}
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
	}
	@Test
	public void checkTitle1()
	{

		logger = report.startTest("Pass Test");
		logger.assignAuthor("smd");
		logger.assignCategory("Funtional test");
		String Expected,Actual;
		Expected = "google";
		Actual = driver.getTitle();
		if(Expected.equalsIgnoreCase(Actual))
		{
			logger.log(LogStatus.PASS,"Title is Matching::"+Expected+"  "+Actual);
			Reporter.log("Title is matching",true);
		}else
		{
			logger.log(LogStatus.FAIL,"Title is not Matching::"+Expected+"  "+Actual);
		}

	}
	@Test
	public void checkTitile2()
	{
		logger = report.startTest("fail test");
		logger.assignAuthor("smd");
		logger.assignCategory("functional test");
		String Expected,Actual;
		Expected = "gmail";
		Actual = driver.getTitle();
		if(Expected.equalsIgnoreCase(Actual))
		{
			logger.log(LogStatus.PASS,"Title is Matching::"+Expected+"  "+Actual);
		}else
		{
			logger.log(LogStatus.FAIL,"Title is not Matching::"+Expected+"  "+Actual);
			Reporter.log("Title is not matching",true);
		}


	}
	@AfterMethod
	public void tearDown()
	{

		report.endTest(logger);
		report.flush();
		driver.quit();

	}



}

