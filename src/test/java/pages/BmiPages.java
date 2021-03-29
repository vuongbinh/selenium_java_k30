package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class BmiPages extends BasePage {
    /**
     * suffix
     * btn: Button
     * txt: Text
     * rad: Radio button
     * chk: Check box
     * link: LinkText
     * lbl: Label
     * ...
     */

    By clearBtn = By.className("clearbtn");
    By metricUnitTab = By.id("menuon");
    By ageTxt = By.id("cage");
    By maleRad = By.id("csex1");
    By femaleRad = By.id("csex2");
    By heightTxt = By.id("cheightmeter");
    By weightTxt = By.id("ckg");
    By calculatorBtn = By.xpath("//*[@alt='Calculate']");
    By result = By.className("bigtext");

    public enum Genders {
        male,
        female
    }

    public void open(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    public BmiPages(WebDriver driver) {
        super(driver);
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }

    public void fillForm(String age, Genders genders, String height, String weight) {
        driver.findElement(clearBtn).click();
        driver.findElement(ageTxt).sendKeys(age);
        if (Objects.equals(genders, Genders.male)) driver.findElement(maleRad).click();
        else driver.findElement(femaleRad).click();
        driver.findElement(heightTxt).sendKeys(height);
        driver.findElement(weightTxt).sendKeys(weight);
        driver.findElement(calculatorBtn).click();
    }

    public void openMetricTab() {
        driver.findElement(metricUnitTab).click();
    }
}
