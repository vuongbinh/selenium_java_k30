package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Browsers {
    private WebDriver driver = null;
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
    public void redirectTo(String url){
        driver.get(url);
    }
    public WebElement find(How type,String locator){
        return driver.findElement(type.buildBy(locator));
    }
    public void resultByUrl(String expected){
        Assert.assertTrue(driver.getCurrentUrl().contains(expected));
    }
    public void errorChecking(String expected){
        Assert.assertTrue(find(How.ID, "flash").getText().contains(expected));
    }
    public void close(){
        driver.quit();
    }
}
