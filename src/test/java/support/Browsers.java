package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.How;

public class Browsers {
    private WebDriver driver;
    public void open(String browser){
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
    }
    public void redirectTo(String url){
        driver.get(url);
    }
    public WebElement find(String how,String locator){
        switch (how)
        case "xpath":
        WebElement element = driver.findElement(By.xpath(locator));
        return element;
    }
    public void close(){
        driver.quit();
    }
}
