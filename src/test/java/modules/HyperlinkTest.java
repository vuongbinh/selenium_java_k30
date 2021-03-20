package modules;

import org.openqa.selenium.support.How;
import org.testng.annotations.*;
import support.Browsers;

public class HyperlinkTest {
    Browsers browsers = new Browsers();
    @BeforeMethod
    void setup(){
        //1.Open browser
        browsers.open("chrome");
        browsers.navigateTo("https://the-internet.herokuapp.com/status_codes");
    }

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
    void navigateToPage(String name){
        browsers.validate(name,"linktext");
        browsers.find(How.LINK_TEXT,"here").click();
    }


    @AfterMethod
    void tearDown(){
        browsers.close();
    }
}
