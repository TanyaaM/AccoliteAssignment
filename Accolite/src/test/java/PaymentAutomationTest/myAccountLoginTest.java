package PaymentAutomationTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjects.AddCartPage;
import pageObjects.myAccountPage;
import pageObjects.paymentPage;
import resources.GenericUtils;
import resources.baseClass;

public class myAccountLoginTest extends baseClass {


	@Test(priority=1)
	public void LoginTest() throws IOException
	{

		initializeBrowser();
		getURL();
		myAccountPage ap=new myAccountPage(driver);
		ap.clickMyaccount();
		ap.enterUsername();
		ap.enterPassword();
		ap.clickLogintn();
		String eTitle="My account - https://www.tediline.com";
		String aTitle=driver.getTitle();
		System.out.println(aTitle);
		Assert.assertEquals(aTitle, eTitle, "Unsuccessful login");
		GenericUtils.getScreenshot(driver);

}
	@Test(priority=2)
	public void AddItem() throws IOException
	{

		AddCartPage ap=new AddCartPage(driver);
		ap.clickLaptopAccessories();
		ap.selectLaptopSleeve();
		ap.selectItem();
		ap.selectSize(1);
		ap.clickAddToCart();
		ap.VerifyViewCartBtn();
		ap.clickProceedToCheckoutBtn();
		String eTitle="Checkout - https://www.tediline.com";
		String aTitle=driver.getTitle();
		Assert.assertEquals(aTitle, eTitle, "Unsuccessful checkout");
		GenericUtils.getScreenshot(driver);



}

	@Test(enabled=false)
	public void verifyCheckoutAndCardPayment() {

		paymentPage p=new paymentPage(driver);
		p.verifyCreditCardRadioButtonIsSelected();
		p.clickPlaceOrderBtn();
		p.selectCardPayment();


}
	@Test(priority=3)
	public void verifyCheckoutAndUpiPayment() throws IOException, InterruptedException {

		paymentPage p=new paymentPage(driver);
		p.verifyCreditCardRadioButtonIsSelected();
		p.clickPlaceOrderBtn();
		//p.selectCardPayment();
		p.selectUPIPayment();


}

	@AfterMethod
	public void postCondition(ITestResult res)
	{
		int status=res.getStatus();
		if(status==2)
		{
			String name=res.getName();
			Reporter.log("test is failed",true);
			Reporter.log("Failed test method name"+name,true);
			GenericUtils.getScreenshot(driver);

		}
		else
		{
			Reporter.log("test is passed without any failure",true);
			//driver.quit();
		}
}
}
