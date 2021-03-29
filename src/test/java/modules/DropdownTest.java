package modules;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest{
    @DataProvider Object[][] dropdownData(){
        return new Object[][]{
                new Object[]{"Option 1", "2"},
                new Object[]{"Option 2", "3"}
        };
    }
    @Test(dataProvider = "dropdownData")
    static void validateDropdown(String option, String index){
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.open();
        dropdownPage.select(option);

        Assert.assertEquals(dropdownPage.getResult(index),option);

    }

}
