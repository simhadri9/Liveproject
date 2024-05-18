package property;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Create_new_role 
{
Properties pro;
WebDriver driver;
@BeforeTest
public void role() throws Throwable, IOException
{

	pro = new Properties();
	pro.load(new FileInputStream("OR.properties"));
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get(pro.getProperty("Url"));
	driver.findElement(By.xpath(pro.getProperty("Objuser"))).sendKeys("Admin");
	driver.findElement(By.xpath(pro.getProperty("Objpass"))).sendKeys("Admin");
	driver.findElement(By.xpath(pro.getProperty("Objlogin"))).click();
}
@Test
public void startTest() throws Throwable
{
	driver.findElement(By.xpath(pro.getProperty("objrole"))).click();
	driver.findElement(By.xpath(pro.getProperty("objnewrole"))).click();
	driver.findElement(By.xpath(pro.getProperty("objrolename"))).sendKeys("maharaj");
	driver.findElement(By.xpath(pro.getProperty("objroledesc"))).sendKeys("a123786");
	Thread.sleep(2000);
	new Select(driver.findElement(By.xpath(pro.getProperty("objroletype")))).selectByVisibleText("E");
	driver.findElement(By.xpath(pro.getProperty("objsubmit"))).click();
	Thread.sleep(2000);
	
	String altmsg = driver.switchTo().alert().getText();
	System.out.println(altmsg);
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	
}
@AfterTest
public void tearDown()
{

	driver.quit();
}
	
}
