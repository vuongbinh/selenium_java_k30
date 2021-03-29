package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HyperLinkPage extends BasePage {

    public HyperLinkPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }

    public void click(String errorCode) {
        driver.findElement(By.linkText(errorCode)).click();
    }

    public boolean getResult(String errorCode) {
        return driver.getCurrentUrl().contains(String.format("status_codes/%s",errorCode));
    }
}
