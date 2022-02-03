package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.baseClass;

public class myAccountPage extends baseClass {

	


	@FindBy(xpath="//div[@class='main-header-bar thnk-col-3']//span[contains(text(),'My account')]")
	private WebElement myAccount;

	@FindBy(xpath="//input[@id='username']")
	private WebElement userName;

	@FindBy(xpath="//input[@id='password']")
	private WebElement pword;

	@FindBy(xpath="//button[@name='login']")
	private WebElement loginBtn;


	public myAccountPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}


	public void clickMyaccount()
	{
	myAccount.click();
	}

	public void enterUsername() throws IOException
	{
	String uName=validUsername();
	userName.sendKeys(uName);
	}

	public void enterPassword() throws IOException
	{
	String password=validPassword();
	pword.sendKeys(password);
	}

	public void clickLogintn()
	{
	loginBtn.click();
	}




}
