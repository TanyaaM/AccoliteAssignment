package resources;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class GenericUtils {

	/*
	 * This function will move cursor to the element
	 */
	public static void mouseHover(WebDriver driver,WebElement element)
	{

	Actions act=new Actions(driver);
	act.moveToElement(element).perform();

	}

	public static void SelectByIndex(WebElement element, int index)
	{
	Select sel=new Select(element);
	sel.selectByIndex(index);
	}

	public static void getScreenshot(WebDriver driver)
	{
	try
	{
	TakesScreenshot t=(TakesScreenshot)driver;
	File src=t.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshots.png");
	FileUtils.copyFile(src,dest);

	}
	catch(Exception e)
	{

	}}
	public static void verifyElementIsClickable(WebDriver driver,WebElement  element)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	try
	{
	wait.until(ExpectedConditions.elementToBeClickable(element));
	Reporter.log("Element is present",true);
	}
	catch(Exception e)
	{
	Reporter.log("Element is not clickable",true);
	Assert.fail();
	}

}}
