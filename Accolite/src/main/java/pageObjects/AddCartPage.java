package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.GenericUtils;
import resources.baseClass;

public class AddCartPage extends baseClass {

	@FindBy(xpath="//span[contains(text(),'Laptop Accessories')]")
	WebElement laptopAccessories;

	@FindBy(xpath="//span[@class='top-store-menu-link' and contains(text(),'Laptop Sleeve / Cover / Bag')]")
	WebElement laptopSleeve;

	@FindBy(xpath="//div[@class='thunk-product']//h2[contains(text(),'Laptop Sleeve Colorfull Doodle')]")
	WebElement item;

	@FindBy(xpath="//select[@id='size']")
	WebElement sizeDropbox;

	@FindBy(xpath="//button[@type='submit' and contains(text(),'Add to cart')]")
	private WebElement addToCartBtn;

	@FindBy(xpath="//div[@class='woocommerce-message']//a[contains(text(),'View cart')]")
	private WebElement viewCartBtn;

	@FindBy(xpath="//a[@class='checkout-button button alt wc-forward']")
	private WebElement proceedToCheckoutBtn;

	public AddCartPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	public void clickLaptopAccessories()
	{
	//laptopAccessories.click();
		
	GenericUtils.mouseHover(driver, laptopAccessories);
	}

	public void selectLaptopSleeve()
	{
	laptopSleeve.click();
	}

	public void selectItem()
	{
	item.click();
	}


	public void selectSize(int index)
	{
	GenericUtils.SelectByIndex(sizeDropbox, index);

	}

	public void clickAddToCart()
	{
	addToCartBtn.click();
	}
	//test
	public void VerifyViewCartBtn()
	{
	verifyElementIsVisible(viewCartBtn);
	viewCartBtn.click();
	}

	public void clickProceedToCheckoutBtn()
	{
	proceedToCheckoutBtn.click();
	}
}
