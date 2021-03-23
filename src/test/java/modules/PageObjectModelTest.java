package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import support.Browsers;

public class PageObjectModelTest {
    private static WebDriver driver;
    @BeforeMethod
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }
    @Test
    void validatePageObject(){
        driver.findElement(By.xpath("//a[contains(text(),'Metric Units')]")).click();
        driver.findElement(By.id("cage")).sendKeys("25");

    }
    @AfterMethod
    void tearDown(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
