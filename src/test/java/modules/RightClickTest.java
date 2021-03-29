package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClickTest {
    static WebDriver driver;


    @BeforeMethod
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }

    @Test
    static void tc01(){
        WebElement hotPot = driver.findElement(By.id("hot-spot"));

        Actions mouse = new Actions(driver);
        mouse.contextClick(hotPot).perform();

        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));

        String jsContext = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(jsContext,"You selected a context menu");
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
