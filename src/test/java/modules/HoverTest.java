package modules;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HoverPage;

public class HoverTest extends BaseTest {

    @DataProvider
    Object[][] user() {
        return new Object[][]{
                new Object[]{"user1", "name: user1"},
                new Object[]{"user2", "name: user2"},
                new Object[]{"user3", "name: user3"},
        };
    }

    @Test(dataProvider = "user")
    void hoverAvatar1(String name, String expected) {
        HoverPage hoverPage = new HoverPage(driver);
        hoverPage.open();
        hoverPage.hover(name);
        Assert.assertTrue(hoverPage.getResult(name).contains(expected));
    }
}
