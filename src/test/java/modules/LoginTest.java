package modules;

import org.testng.annotations.Test;
import support.Browsers;

public class LoginTest {
@Test
    void validateLogin(){
    Browsers browser = new Browsers();
    //Step 1: open browser
    browser.open("firefox");
    //Step 2: Redicect to:https://the-internet.herokuapp.com/login
    browser.redirectTo("https://the-internet.herokuapp.com/login");
    //Step 3: Fill in username with tomsmith

    //Step 4: Fill in the password with SuperSecretPassword!

    //Step 5: Click on Login button



    }
}
