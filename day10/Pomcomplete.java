package BaseClassUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pomcomplete {
	WebDriver driver;
    Pomcomplete(WebDriver driver){
    	this.driver = driver;
		 PageFactory.initElements(driver,this);
    }
    
    @FindBy(xpath="//h2[normalize-space()='Thank you for your order!']")
    private WebElement Thankyou;
	public WebDriver getDriver() {
		return driver;
	}

	public String getThankyou() {
		return Thankyou.getText();
	}
    
    
}
