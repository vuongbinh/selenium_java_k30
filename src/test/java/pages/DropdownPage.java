package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    By drp = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public void select(String option) {
        Select opt = new Select(driver.findElement(drp));
        opt.selectByVisibleText(option);
    }

    public String getResult(String index){
        return driver.findElement(By.xpath("//*[@id='dropdown']/Option[%s]".formatted(index))).getText();
    }
}
