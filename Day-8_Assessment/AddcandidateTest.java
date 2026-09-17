package OrangeHRM;

import java.io.File;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddcandidateTest {

    public static void main(String[] args) throws Exception {

        // Open browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open OrangeHRM
        driver.get( "https://opensource-demo.orangehrmlive.com/");

        // LOGIN
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")) .click();
        Thread.sleep(3000);
        System.out.println("Login successful");

        // RECRUITMENT
        driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
        Thread.sleep(5000);

        // ADD
        driver.findElement(By.xpath("//button[contains(.,'Add')]")).click();
        Thread.sleep(5000);

        // FIRST NAME
        driver.findElement(By.name("firstName")).sendKeys("Pavan");

        // MIDDLE NAME
        driver.findElement(By.name("middleName")).sendKeys("Kumar");

        // LAST NAME
        driver.findElement(By.name("lastName")).sendKeys("Reddy");

        // VACANCY
        driver.findElement(By.xpath("//label[text()='Vacancy']" + "/following::div[contains(@class," + "'oxd-select-text')][1]")).click();
        Thread.sleep(5000);

        List<WebElement> vacancy = driver.findElements(By.xpath("//div[@role='option']"));
        if (vacancy.size() > 1) {
            vacancy.get(1).click();
        }

        // EMAIL
        driver.findElement(By.xpath( "//label[text()='Email']" + "/following::input[1]")).sendKeys("pavan123@gmail.com");

        // CONTACT NUMBER
        driver.findElement(By.xpath("//label[text()='Contact Number']"  + "/following::input[1]")) .sendKeys("9876543210");

        // UPLOAD RESUME
        String resumePath = System.getProperty("user.dir") + ".\\src\\test\\resources\\DDT\\XlSauceDemo.xlsx";
        File resume = new File(resumePath);
        if (resume.exists()) {
            driver.findElement( By.xpath("//input[@type='file']")) .sendKeys(resume.getAbsolutePath());
            System.out.println("Resume uploaded");
        } else {
            System.out.println("Resume not found:");
            System.out.println(resumePath);
        }

        // SAVE
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        System.out.println("Candidate saved");

        // CANDIDATES
        driver.findElement( By.xpath("//a[text()='Candidates']")).click();
        Thread.sleep(5000);

        // CANDIDATE NAME
        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        System.out.println("Number of input fields: " + inputs.size());
        if (inputs.size() > 0) {
            inputs.get(0).sendKeys("Pavan");
        } else {
            System.out.println("Candidate Name field not found");
        }

        // SEARCH
        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        System.out.println( "Number of buttons: " + buttons.size());
        boolean searchClicked = false;
        for (WebElement button : buttons) {
            String text = button.getText().trim();
            System.out.println("Button: " + text);
            if (text.equalsIgnoreCase("Search")) {
                button.click();
                searchClicked = true;
                break;
            }
        }
        if (!searchClicked) {
            System.out.println("Search button not found");
        } else {
            System.out.println("Search button clicked");
        }
        Thread.sleep(5000);

        // VERIFY
        String pageText = driver.findElement(By.tagName("body")).getText();
        if (pageText.contains("Pavan") && pageText.contains("Reddy")) {
            System.out.println("PASS: Candidate found");
        } else {
            System.out.println("FAIL: Candidate not found");
        }

        // LOGOUT
        driver.findElement(By.xpath("//span[contains(@class," + "'oxd-userdropdown-tab')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(5000);
        System.out.println("Logout successful");
    }
}