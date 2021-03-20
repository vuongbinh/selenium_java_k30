package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest {
    private static WebDriver driver;
    @BeforeMethod
    void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }
    @Test
    static void checkInnerText(){
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("LEFT")
                ,driver.findElement(By.xpath("html/body")).getText()
        );
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("MIDDLE")
                ,driver.findElement(By.xpath("html/body")).getText()
        );
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("RIGHT")
                ,driver.findElement(By.xpath("html/body")).getText()
        );

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("BOTTOM")
                ,driver.findElement(By.xpath("html/body")).getText()
        );

    }
    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
