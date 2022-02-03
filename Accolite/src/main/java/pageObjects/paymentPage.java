package pageObjects;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.GenericUtils;
import resources.baseClass;

public class paymentPage extends baseClass {

	@FindBy(xpath="//input[@id='payment_method_razorpay']")
	private WebElement creditCardRadioBtn;

	@FindBy(id="place_order")
	private WebElement placeOrderBtn;

	@FindBy(xpath="//iframe[@class='razorpay-checkout-frame']")
	private WebElement frame;


	//Google Pay, PhonePe & more
	@FindBy(xpath="//body//div[@id='modal']//div[@slot='subtitle' and contains(text(),'Visa, MasterCard, RuPay, and Maestro')]")
	private WebElement cardPayment;

	@FindBy(xpath="//div[@class='methods-block']//div[@role='list']//button//div[@class='svelte-1u727jy']//div[@slot='title' and contains(text(),'UPI / QR')]")
	private WebElement upiPayment;

	@FindBy(xpath="//div[@type='button']//div[@class='svelte-zf5zxn']")
	private WebElement upiId;
	
	@FindBy(xpath="//input[@class='input main svelte-1xgql54']")
	private WebElement enterUpi;

	@FindBy(xpath="//div[@id='footer']//span[@id='footer-cta']")
	private WebElement payBtn;


	public paymentPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}


	public void verifyCreditCardRadioButtonIsSelected()
	{
	if(creditCardRadioBtn.isSelected())
	{
		System.out.println("Credit card button is already selected");
	}
	else
	{
	creditCardRadioBtn.click();
	System.out.println("User selected the credit ");
	}
	}

	public void clickPlaceOrderBtn()
	{
	placeOrderBtn.click();
	}

	public void selectCardPayment()
	{
	driver.switchTo().frame(frame);
	//verifyElementIsVisible(cardPayment);
	cardPayment.click();
	}

	public void selectUPIPayment() throws IOException, InterruptedException
	{
	String upiName=validUpiName();
	driver.switchTo().frame(frame);
	GenericUtils.verifyElementIsClickable(driver, upiPayment);
	//Thread.sleep(3000);
	upiPayment.click();
	upiId.click();
	enterUpi.sendKeys(upiName);
	payBtn.click();
	//enterUpi.sendKeys(Keys.ENTER);

	}

}
