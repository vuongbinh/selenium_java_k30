package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class CheckBoxPage extends BasePage {
    HashMap<String, By> checkboxes = new HashMap<>();

    By chk1 = By.xpath("//form[@id='checkboxes']//input[1]");
    By chk2 = By.xpath("//form[@id='checkboxes']//input[2]");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkboxes.put("checkbox1",chk1);
        checkboxes.put("checkbox2",chk2);
    }

    public void check(String name){
        WebElement checkbox = driver.findElement(checkboxes.get(name));
        if (!checkbox.isSelected()){
            checkbox.click();
        }
    }

    public void uncheck(String name){
        WebElement checkbox = driver.findElement(checkboxes.get(name));
        if (checkbox.isSelected()){
            checkbox.click();
        }
    }

    public boolean getResult(String name){
        return driver.findElement(checkboxes.get(name)).isSelected();
    }
}
