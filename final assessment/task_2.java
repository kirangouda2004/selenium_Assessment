package lastdayassessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class task_2 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
        WebElement ele=driver.findElement(By.id("slide"));
        Actions act=new Actions(driver);
        act.clickAndHold(ele).moveByOffset(200,0).release().perform();;
        Thread.sleep(2000);
        WebElement jacket=driver.findElement(By.xpath("//h3[contains(text(),'Mens Cotton Jacket')]"));
        System.out.println("Product: "+jacket.getText());

    }
}
		
		
		
		
		
		
		
//		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
//        Actions a = new Actions(driver);       
//        a.dragAndDropBy(slider, 200, 0).perform();
//        WebElement text = driver.findElement(By.xpath("//*[text()='Mens Cotton Jacket']"));
//        if(text.getText().equals("Mens Cotton Jacket")) {
//            System.out.println("Verified");
//        }
//        
//
//
//	}
//}
//
