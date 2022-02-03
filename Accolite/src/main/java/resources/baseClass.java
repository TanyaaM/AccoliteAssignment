package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseClass {

	public WebDriver driver;

	public WebDriver initializeBrowser() throws IOException
	{


	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream("D:\\project\\Accolite\\src\\main\\java\\resources\\GlobalVariables.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	if(browserName.equals("Chrome"))
	{
	System.out.println("Executing test in chrome browser");
	System.setProperty("webdriver.chrome.driver", "D:\\project\\Accolite\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();

	}
	else if(browserName.equals("IE"))
	{
	System.out.println("Executing test in IE browser");
	System.setProperty("webdriver.ie.driver", "D:\\project\\Accolite\\drivers\\IEDriver.exe");
	driver=new InternetExplorerDriver();
	}
	else if(browserName.equals("firefox"))
	{
	System.out.println("Executing test in firefox browser");
	System.setProperty("webdriver.gecko.driver","D:\\project\\Accolite\\drivers\\geckodriver.exe");
	driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();

	return driver;
	}
 



	public String getURL() throws IOException {
	// TODO Auto-generated method stub
	Properties prop= new Properties();
	FileInputStream fis =new FileInputStream("D:\\project\\Accolite\\src\\main\\java\\resources\\GlobalVariables.properties");
	prop.load(fis);
	String url=prop.getProperty("url");
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return url;

	}


	public String validUsername() throws IOException
	{
	Properties prop= new Properties();
	FileInputStream fis =new FileInputStream("D:\\project\\Accolite\\src\\main\\java\\resources\\GlobalVariables.properties");
	prop.load(fis);
	String validUsername=prop.getProperty("username");
	return validUsername;
	}

	public String validPassword() throws IOException
	{
	Properties prop= new Properties();
	FileInputStream fis =new FileInputStream("D:\\project\\Accolite\\src\\main\\java\\resources\\GlobalVariables.properties");
	prop.load(fis);
	String validpassword=prop.getProperty("password");
	return validpassword;
	}

	public String validUpiName() throws IOException
	{
	Properties prop= new Properties();
	FileInputStream fis =new FileInputStream("D:\\project\\Accolite\\src\\main\\java\\resources\\GlobalVariables.properties");
	prop.load(fis);
	String validUpiName=prop.getProperty("upiname");
	return validUpiName;
	}

	public void verifyElementIsVisible(WebElement element)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	try
	{
	wait.until(ExpectedConditions.visibilityOf(element));
	Reporter.log("Element is present",true);
	}
	catch(Exception e)
	{
	Reporter.log("Element is not clickable",true);
	Assert.fail();
	}
	}
}
