package property;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PropetyFile {
Properties pp;
WebDriver driver;
@BeforeTest
public void setUp()throws Throwable
{
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	pp=new Properties();
	pp.load(new FileInputStream("OR.properties"));
	driver.get(pp.getProperty("Url"));
	
	driver.findElement(By.xpath(pp.getProperty("Objuser"))).sendKeys("Admin");
	driver.findElement(By.xpath(pp.getProperty("Objpass"))).sendKeys("Admin");
	driver.findElement(By.xpath(pp.getProperty("Objlogin"))).click();
}
	@Test
	public void stsrtTest() throws Throwable
	{
		driver.findElement(By.xpath(pp.getProperty("Objbranch"))).click();
		driver.findElement(By.xpath(pp.getProperty("Objnewbranch"))).click();
		
		driver.findElement(By.xpath(pp.getProperty("ObjBranchname"))).sendKeys("podili");
		Thread.sleep(2000);
		driver.findElement(By.xpath(pp.getProperty("ObjAddress1"))).sendKeys("srnagar2");
		driver.findElement(By.xpath(pp.getProperty("ObjAdress2"))).sendKeys("kadiri");
		driver.findElement(By.xpath(pp.getProperty("ObjAdress3"))).sendKeys("ongole");
		driver.findElement(By.xpath(pp.getProperty("ObjArea"))).sendKeys("lic colony");
		
		driver.findElement(By.xpath(pp.getProperty("ObjZip"))).sendKeys("78614");
		new Select(driver.findElement(By.xpath(pp.getProperty("Objcountry")))).selectByVisibleText("INDIA");
		new Select(driver.findElement(By.xpath(pp.getProperty("Objstste")))).selectByVisibleText("GOA");
		new Select(driver.findElement(By.xpath(pp.getProperty("ObjCity")))).selectByVisibleText("GOA");
		driver.findElement(By.xpath(pp.getProperty("ObjSubmit"))).click();
		Thread.sleep(4000);
		String altmsg = driver.switchTo().alert().getText();
		System.out.println(altmsg);
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
