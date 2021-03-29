package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By usernameTxt = By.id("username");
    By passwordTxt = By.id("password");
    By loginBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void login(String usm, String pwd){
        driver.findElement(usernameTxt).sendKeys(usm);
        driver.findElement(passwordTxt).sendKeys(pwd);
        driver.findElement(loginBtn).click();
    }

}
