package POM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Candidate {

    WebDriver driver;
    WebDriverWait wait;

    By candidatesTab = By.xpath("//a[normalize-space()='Candidates']");

    By jobTitle = By.xpath("//label[normalize-space()='Job Title']/following-sibling::div//div[contains(@class,'oxd-select-text')]");

    By vacancy = By.xpath("//label[normalize-space()='Vacancy']/following-sibling::div//div[contains(@class,'oxd-select-text')]");

    By hiringManager = By.xpath("//label[normalize-space()='Hiring Manager']/following-sibling::div//div[contains(@class,'oxd-select-text')]");

    By status = By.xpath("//label[normalize-space()='Status']/following-sibling::div//div[contains(@class,'oxd-select-text')]");

    By candidateName = By.xpath("//label[normalize-space()='Candidate Name']/following-sibling::div//input");

    By fromDate = By.xpath("//input[@placeholder='From']");

    By toDate = By.xpath("//input[@placeholder='To']");

    By methodOfApplication = By.xpath("//label[normalize-space()='Method of Application']/following-sibling::div//div[contains(@class,'oxd-select-text')]");

    By searchButton = By.xpath("//button[normalize-space()='Search']");

    public Candidate(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Click Candidates
    public void clickCandidates() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(candidatesTab)).click();

        Thread.sleep(3000);
    }

    // Select Job Title
    public void selectJobTitle(String value) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(jobTitle)).click();

        Thread.sleep(1000);

        By option = By.xpath("//div[@role='option']//span[normalize-space()='" + value + "']");

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

        Thread.sleep(1500);
    }

    // Select Vacancy
    public void selectVacancy(String value) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(vacancy)).click();

        Thread.sleep(1000);

        By option = By.xpath("//div[@role='option']//span[normalize-space()='" + value + "']");

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

        Thread.sleep(1500);
    }

    // Select Hiring Manager
    public void selectHiringManager(String value) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(hiringManager)).click();

        Thread.sleep(1000);

        By option = By.xpath("//div[@role='option']//span[normalize-space()='" + value + "']");

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

        Thread.sleep(1500);
    }

    // Select Status
    public void selectStatus(String value) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(status)).click();

        Thread.sleep(1000);

        By option = By.xpath("//div[@role='option']//span[normalize-space()='" + value + "']");

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

        Thread.sleep(1500);
    }

    // Enter Candidate Name
    public void enterCandidateName(String value) throws InterruptedException {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(candidateName));

        element.click();
        element.clear();
        element.sendKeys(value);

        Thread.sleep(3000);

        By suggestion = By.xpath("//div[@role='option'][1]");

        wait.until(ExpectedConditions.elementToBeClickable(suggestion)).click();

        Thread.sleep(1500);
    }

    // Enter From Date
    public void enterFromDate(String value) throws InterruptedException {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fromDate));

        element.click();
        element.clear();
        element.sendKeys(value);

        Thread.sleep(1000);

        element.sendKeys("\t");

        Thread.sleep(1000);
    }

    // Enter To Date
    public void enterToDate(String value) throws InterruptedException {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toDate));

        element.click();
        element.clear();
        element.sendKeys(value);

        Thread.sleep(1000);

        element.sendKeys("\t");

        Thread.sleep(1000);
    }

    // Select Method
    public void selectMethod(String value) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(methodOfApplication)).click();

        Thread.sleep(1000);

        By option = By.xpath("//div[@role='option']//span[normalize-space()='" + value + "']");

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

        Thread.sleep(1500);
    }

    // Click Search
    public void clickSearch() throws InterruptedException {

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        search.click();

        Thread.sleep(5000);
    }

    // Verify Candidate
    public boolean verifyCandidate(String firstName, String lastName) {

        String bodyText = driver.findElement(By.tagName("body")).getText();

        String fullName = firstName + " " + lastName;

        return bodyText.contains(fullName);
    }
}