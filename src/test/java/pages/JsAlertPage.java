package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JsAlertPage extends BasePage{

    By jsAlert = By.xpath("//button[.='Click for JS Alert']");
    By jsConfirm = By.xpath("//button[.='Click for JS Confirm']");
    By jsPrompt = By.xpath("//button[.='Click for JS Prompt']");

    public JsAlertPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public String getResult(String locator){
        return driver.findElement(By.id(locator)).getText();
    }

    public void triggerAlert() {
        driver.findElement(jsAlert).click();
    }

    public void triggerConfirm(String action) {
        driver.findElement(jsConfirm).click();
    }

    public void triggerPrompt(String text) {
        driver.findElement(jsPrompt).click();
        driver.switchTo().alert().sendKeys(text);
    }

    public void accept(){
        driver.switchTo().alert().accept();
    }
    public void dismiss(){
        driver.switchTo().alert().dismiss();
    }
}
