package BaseClassUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutpage {
	WebDriver driver;     
	public CheckOutpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="first-name")
	private WebElement fname;
	
	@FindBy(id="last-name")
	private WebElement lname;
	
	@FindBy(id="postal-code")
	private WebElement Pcode;

	@FindBy(id="continue")
	private WebElement Continue;
	
	

	public void getContinue() {
		Continue.click();
	}



	public void getFname(String value) {
		 fname.sendKeys(value);;
	}

	public void getLname(String value) {
		lname.sendKeys(value);
	}

	public void getPcode(String value) {
		Pcode.sendKeys(value);
	}
	
	
}
