package modules;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.JsAlertPage;

public class JsAlertTest extends BaseTest {

    @Test
    void clickForJsAlert() {
        JsAlertPage jsAlertPage = new JsAlertPage(driver);
        jsAlertPage.open();
        jsAlertPage.triggerAlert();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
        jsAlertPage.accept();
        Assert.assertTrue(jsAlertPage.getResult("result")
                .contains("You successfully clicked an alert"));
    }

    @DataProvider
    static Object[][] Actions() {
        return new Object[][]{
                new Object[]{"Cancel"},
                new Object[]{"Ok"}
        };
    }
    @Test(dataProvider = "Actions")
    void clickForJsConfirmOK(String action) {
        JsAlertPage jsAlertPage = new JsAlertPage(driver);
        jsAlertPage.open();
        jsAlertPage.triggerConfirm(action);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
        if (action.contains("Cancel")) {
            jsAlertPage.dismiss();
        } else {
            jsAlertPage.accept();
        }
        Assert.assertEquals(jsAlertPage.getResult("result")
                ,"You clicked: %s".formatted(action));
    }

    @DataProvider
    Object[][] textData() {
        return new Object[][]{
                new Object[]{"Hello!"},
                new Object[]{"I need your help."},
                new Object[]{"Could you find me?"},
                new Object[]{"Could you help me please!"},
        };
    }
    @Test(dataProvider = "textData")
    void clickForJsPrompt(String text) {
        JsAlertPage jsAlertPage = new JsAlertPage(driver);
        jsAlertPage.open();
        jsAlertPage.triggerPrompt(text);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
        jsAlertPage.accept();
        Assert.assertEquals(jsAlertPage.getResult("result"), "You entered: %s".formatted(text));
    }
}
