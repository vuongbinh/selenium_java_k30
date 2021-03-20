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

import javax.swing.*;

public class HoverTest {
    private static WebDriver driver;
    @BeforeMethod
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
    }
    @Test
    void hoverAvatar1(){
        Actions mouse = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement ava1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        mouse
                .moveToElement(ava1)
                .perform();


        String caption = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='figure'][1]//div/h5")))
                .getText();
        Assert.assertEquals(caption,"name: user1");
        System.out.println(caption);
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
