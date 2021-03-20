package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JsAlertTest {
    private static WebDriver driver;
    @BeforeMethod
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @DataProvider
    static Object[][] confirmAction(){
        return new Object[][]{
                new Object[]{"Cancel"},
                new Object[]{"Ok"}
        };
    }
    @Test
    void clickForJsAlert(){
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));

        driver.switchTo().alert().accept();

        String result = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");
    }
    @Test(dataProvider = "confirmAction")
    void clickForJsConfirmOK(String action){
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));

        if (action.contains("Cancel")){
            driver.switchTo().alert().dismiss();
        }else {
            driver.switchTo().alert().accept();
        }

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: %s".formatted(action));

    }

    @DataProvider Object[][] textData(){
            return new Object[][]{
                new Object[]{"Hello"},
                new Object[]{"Cancel"}
            };
    }
    @Test(dataProvider = "textData")
    void clickForJsPromt(String text){
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));

        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals(result,"You entered: %s".formatted(text));
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
