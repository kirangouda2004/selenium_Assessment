package BaseClassUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomHomePage {
    WebDriver driver;
	public PomHomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement addTocart;
	
	@FindBy(xpath="//span[text()=\"1\"]")
	private WebElement verify1;
	
	@FindBy(xpath="//a[@aria-label=\"Cart, 1 items\"]")
	private WebElement Cart1Item;
	

	public void getAddTocart() {
		addTocart.click();;
	}
	
	

	public String getVerify1() {
		return verify1.getText();
	}



	public void getCart1Item() {
	    Cart1Item.click();
	}
	
	
}
