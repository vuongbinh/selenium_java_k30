package modules;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BmiPages;
import pages.BmiPages.Genders;

public class BmiTest extends BaseTest {

    @Test
    void validatePageObject() {
        BmiPages bmiPages = new BmiPages(driver);
        bmiPages.open();
        bmiPages.openMetricTab();
        bmiPages.fillForm("27", Genders.female, "171", "67");
        Assert.assertTrue(bmiPages.getResult().contains("22.9"));
    }

}
