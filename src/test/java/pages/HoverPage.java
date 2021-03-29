package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class HoverPage extends BasePage {
    HashMap<String, By> usernames = new HashMap<>();

    By user1 = By.xpath("//div[@class='figure'][1]");
    By user2 = By.xpath("//div[@class='figure'][2]");
    By user3 = By.xpath("//div[@class='figure'][3]");

    public HoverPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        usernames.put("user1", user1);
        usernames.put("user2", user2);
        usernames.put("user3", user3);
    }

    public void hover(String name) {
        Actions mouse = new Actions(driver);
        WebElement ava = driver.findElement(usernames.get(name));
        mouse
                .moveToElement(ava)
                .perform();
    }

    public String getResult(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated((usernames.get(name))))
                .getText();
    }
}
