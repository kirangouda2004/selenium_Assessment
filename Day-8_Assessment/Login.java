package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;

    By username = By.name("username");
    By password = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    // Login
    public void login(String user, String pass) throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(username).sendKeys(user);

        Thread.sleep(1000);

        driver.findElement(password).sendKeys(pass);

        Thread.sleep(1000);

        driver.findElement(loginButton).click();

        Thread.sleep(4000);
    }
}