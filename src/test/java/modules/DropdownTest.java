package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DropdownTest {
    static WebDriver driver;
    @BeforeMethod
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }
    @DataProvider Object[][] dropdownData(){
        return new Object[][]{
                new Object[]{"Option 1", "2"},
                new Object[]{"Option 2", "3"}
        };
    }
    @Test(dataProvider = "dropdownData")
    static void validateDropdownOpt1(String optdata,String index){
        Select opt = new Select(driver.findElement(By.id("dropdown")));
        opt.selectByVisibleText(optdata);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='dropdown']/Option[%s]".formatted(index))).isSelected());
    }

    @AfterMethod
    void tearDown(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        driver.close();
    }
}
