package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recruitment {

    WebDriver driver;
    WebDriverWait wait;

    By recruitment = By.xpath("//span[normalize-space()='Recruitment']");

    By addButton = By.xpath("//button[contains(normalize-space(),'Add')]");

    By firstName = By.xpath("//label[normalize-space()='First Name']/following-sibling::div//input");

    By middleName = By.xpath("//label[normalize-space()='Middle Name']/following-sibling::div//input");

    By lastName = By.xpath("//label[normalize-space()='Last Name']/following-sibling::div//input");

    By vacancy = By.xpath("//label[normalize-space()='Vacancy']/following-sibling::div//div[contains(@class,'oxd-select-text')]");

    By email = By.xpath("//label[normalize-space()='Email']/following-sibling::div//input");

    By contactNumber = By.xpath("//label[normalize-space()='Contact Number']/following-sibling::div//input");

    By resume = By.xpath("//input[@type='file']");

    By applicationDate = By.xpath("//label[normalize-space()='Date of Application']/following-sibling::div//input");

    By saveButton = By.xpath("//button[normalize-space()='Save']");

    public Recruitment(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Click Recruitment
    public void clickRecruitment() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(recruitment)).click();

        Thread.sleep(3000);
    }

    // Click Add
    public void clickAdd() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

        Thread.sleep(3000);
    }

    // Enter First Name
    public void enterFirstName(String value) throws InterruptedException {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        element.clear();
        element.sendKeys(value);

        Thread.sleep(700);
    }

    // Enter Middle Name
    public void enterMiddleName(String value) throws InterruptedException {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(middleName));

        element.clear();
        element.sendKeys(value);

        Thread.sleep(700);
    }

    // Enter Last Name
    public void enterLastName(String value) throws InterruptedException {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));

        element.clear();
        element.sendKeys(value);

        Thread.sleep(700);
    }

    // Select Vacancy
    public void selectVacancy(String value) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(vacancy)).click();

        Thread.sleep(1000);

        By option = By.xpath("//div[@role='option']//span[normalize-space()='" + value + "']");

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

        Thread.sleep(1500);
    }

    // Enter Email
    public void enterEmail(String value) throws InterruptedException {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(email));

        element.clear();
        element.sendKeys(value);

        Thread.sleep(700);
    }

    // Enter Contact Number
    public void enterMobile(String value) throws InterruptedException {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(contactNumber));

        element.clear();
        element.sendKeys(value);

        Thread.sleep(700);
    }

    // Upload Resume
    public void uploadResume(String path) throws InterruptedException {

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(resume));

        element.sendKeys(path);

        Thread.sleep(3000);
    }

    // Enter Application Date
    public void enterApplicationDate(String value) throws InterruptedException {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(applicationDate));

        element.click();

        element.clear();

        element.sendKeys(value);

        element.sendKeys("\t");

        Thread.sleep(1500);
    }

    // Click Save
    public void clickSave() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        Thread.sleep(5000);
    }
}