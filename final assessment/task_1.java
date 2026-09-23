package lastdayassessment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class task_1 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
		 List<WebElement> toggles=driver.findElements(By.xpath("//input[@type='checkbox']"));
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        for(WebElement toggle:toggles){
	            js.executeScript("arguments[0].removeAttribute('disabled');",toggle); //the ele is disabled, so remove that disable attribute
	            js.executeScript("arguments[0].click();",toggle);
	            Thread.sleep(1000);
	        }
	        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	        Thread.sleep(2000);
	        if(driver.findElement(By.xpath("//p[text()='Your Order has been successfully placed!']")).isDisplayed())
	        {
	            System.out.println("Order is placed");
	        }
	        else {
	            System.out.println("Not");
	        }
	        driver.quit();
	    }
	}