package BaseClassUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomLogiSause {
    WebDriver driver ; 
	PomLogiSause(WebDriver driver){
    	 this.driver = driver;
    	 PageFactory.initElements(driver,this);
     }
	
	@FindBy(id="user-name")
	private WebElement uname;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(id="login-button")
	private WebElement button;
	

	public void getUname(String value) {
		 uname.sendKeys(value);;
	}

	public void getPass(String value) {
		pass.sendKeys(value);
	}

	public void getButton() {
		button.click();
	}
	
	
}
