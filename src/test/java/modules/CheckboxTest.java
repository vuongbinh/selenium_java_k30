package modules;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

public class CheckboxTest extends BaseTest{

    @DataProvider Object[][] chkName(){
        return new Object[][]{
                new Object[]{"checkbox1"},
                new Object[]{"checkbox2"}
        };
    }

    @Test(dataProvider = "chkName")
    void verifyCheckbox(String name) {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.open();

        checkBoxPage.check(name);
        Assert.assertTrue(checkBoxPage.getResult(name));
    }
}
