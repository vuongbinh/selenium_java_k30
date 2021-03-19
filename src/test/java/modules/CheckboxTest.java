package modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
import support.Browsers;

public class CheckboxTest {
    Browsers browsers = new Browsers();
    @Test
    void checkboxTestonChorme() {
        //1.Open browser
        browsers.open("chrome");
        //2. Navigate to https://the-internet.herokuapp.com/checkboxes
        browsers.redirectTo("https://the-internet.herokuapp.com/checkboxes");
        //3. Check on “checkbox1"
        WebElement checkbox1 = browsers.find(How.XPATH,"//form[@id='checkboxes']//input[1]");
        browsers.check(checkbox1);
        //4. Verify “checkbox1” is checked
        Assert.assertTrue(checkbox1.isSelected());
        //5. Check on “checkbox2”
        WebElement checkbox2 = browsers.find(How.XPATH,"//form[@id='checkboxes']//input[2]");
        browsers.check(checkbox2);
        //6. Verify “checkbox2” is checked
        Assert.assertTrue(checkbox2.isSelected());
        //7. Close
        browsers.close();
    }
    @Test
    void checkboxTestonFirefox() {
        //1.Open browser
        browsers.open("firefox");
        //2. Navigate to https://the-internet.herokuapp.com/checkboxes
        browsers.redirectTo("https://the-internet.herokuapp.com/checkboxes");
        //3. Check on “checkbox1"
        WebElement checkbox1 = browsers.find(How.XPATH,"//form[@id='checkboxes']//input[1]");
        browsers.check(checkbox1);
        //4. Verify “checkbox1” is checked
        Assert.assertTrue(checkbox1.isSelected());
        //5. Check on “checkbox2”
        WebElement checkbox2 = browsers.find(How.XPATH,"//form[@id='checkboxes']//input[2]");
        browsers.check(checkbox2);
        //6. Verify “checkbox2” is checked
        Assert.assertTrue(checkbox2.isSelected());
        //7. Close
        browsers.close();
    }
}
