package BaseClassUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pomcart {
    WebDriver driver;     
	Pomcart(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[normalize-space()='Sauce Labs Backpack']")
	private WebElement verifyBag;
	

	public String getVerifyBag() {
		return verifyBag.getText();
	}
	
	@FindBy(id="checkout")
	private WebElement checkout;
	
	public void getCheckout() {
		 checkout.click();
	}
	
	
	
	
	
}
