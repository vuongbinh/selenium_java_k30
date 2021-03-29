package modules;

import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HyperLinkPage;
import support.Browsers;

public class HyperlinkTest extends BaseTest{

    @DataProvider
    static Object[][] pages(){
        return new Object[][]{
                new Object[]{"200"},
                new Object[]{"301"},
                new Object[]{"404"},
                new Object[]{"500"},
        };
    }
    @Test(dataProvider = "pages")
    void navigateToPage(String errorCode){
        HyperLinkPage hyperLinkPage = new HyperLinkPage(driver);
        hyperLinkPage.open();

        hyperLinkPage.click(errorCode);

        Assert.assertTrue(hyperLinkPage.getResult(errorCode));
    }

}
