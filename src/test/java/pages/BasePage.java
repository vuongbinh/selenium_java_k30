package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract void open();

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
