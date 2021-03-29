package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

public class Browsers {
    private WebDriver driver = null;
    public WebDriver browser(){
        return driver;
    }
    public void open(String browser){
        switch (browser) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }
    }
    public void navigateTo(String url){
        driver.get(url);
    }
    public WebElement find(How type,String locator){
        return driver.findElement(type.buildBy(locator));
    }
    public List<WebElement> findMultiple(How type, String locator){
        return driver.findElements(type.buildBy(locator));
    }

    public WebDriver getText() {
        return driver;
    }

    public void validate(String expected, String type){
        switch (type){
            case "url":
                Assert.assertTrue(driver.getCurrentUrl().contains(expected));
            case "title":
                Assert.assertTrue(driver.getTitle().contains(expected));
            case "linktext":
                driver.findElement(By.linkText(expected)).click();
                Assert.assertTrue(driver.getCurrentUrl().contains(String.format("status_codes/%s",expected)));
        }

    }
    public void errorChecking(String expected, String errorCode){
        Assert.assertTrue(find(How.ID, errorCode).getText().contains(expected));
    }
    public void check(WebElement checkbox){
        if (!checkbox.isSelected()){
            checkbox.click();
        }
    }
    public void unCheck(WebElement checkbox){
        if (checkbox.isSelected()){
            checkbox.click();
        }
    }



    public void close(){
        driver.quit();
    }
}
