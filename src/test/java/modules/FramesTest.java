package modules;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramePage;

public class FramesTest extends BaseTest {

    @Test
    static void checkInnerText() {
        FramePage framePage = new FramePage(driver);
        framePage.open();

        framePage.switchToFrame("frame-top");
        framePage.switchToFrame("frame-left");

        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("LEFT")
                ,driver.findElement(By.xpath("html/body")).getText());
    }
}
