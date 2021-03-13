package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {
    public static void main(String[] args){
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new  ChromeDriver();
        driver.get("https://cuhavp.github.io/open-browser/");
        //driver.manage().window().fullscreen();
        driver.get("https://www.google.com/");
        driver.navigate().back();
        driver.quit();
    }
}
