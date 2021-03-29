package pages;

import org.openqa.selenium.WebDriver;

public class FramePage extends BasePage{
    public FramePage(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame(String frameName){
        driver.switchTo().frame(frameName);
    }

    public void back(){
        driver.switchTo().parentFrame();
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }
}
