package practies;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Second {
	Properties pp;
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws Throwable, IOException
	{
		pp = new Properties();
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		pp.load(new FileInputStream("OR.properties"));
		driver.get(pp.getProperty("url"));
			
	}
	@Test
	public void adminlogin()
	{
	driver.findElement(By.xpath(pp.getProperty("objuser"))).sendKeys("Admin");
	driver.findElement(By.xpath(pp.getProperty("objpass"))).sendKeys("Qedge123!@#");
	driver.findElement(By.xpath(pp.getProperty("objlogin"))).click();
	if(driver.findElement(By.xpath(pp.getProperty("objadmin"))).isDisplayed())
	{
		System.out.println("login success");
	}else
	{
		System.out.println("login fail");
	}
	driver.findElement(By.xpath(pp.getProperty("objwelcome"))).click();
	driver.findElement(By.xpath(pp.getProperty("objlogout"))).click();
	
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
