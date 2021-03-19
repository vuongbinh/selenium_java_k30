package modules;

import org.openqa.selenium.support.How;
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
    browser.find(How.ID,"username").sendKeys("tomsmith");
    //Step 4: Fill in the password with SuperSecretPassword!
    browser.find(How.ID,"password").sendKeys("SuperSecretPassword!");
    //Step 5: Click on Login button
    browser.find(How.XPATH,"//button[@type='submit']").click();
    //Step 6: Verify that login is succeed
    browser.resultByUrl("/secure");
    //Step 7: Quit
    browser.close();
    }
@Test
    void validateLoginFailed(){
        Browsers browser = new Browsers();
        //Step 1: open browser
        browser.open("firefox");
        //Step 2: Redicect to:https://the-internet.herokuapp.com/login
        browser.redirectTo("https://the-internet.herokuapp.com/login");
        //Step 3: Fill in username with tomsmith
        browser.find(How.ID,"username").sendKeys("tomsmith1");
        //Step 4: Fill in the password with SuperSecretPassword!
        browser.find(How.ID,"password").sendKeys("SuperSecretPassword!");
        //Step 5: Click on Login button
        browser.find(How.XPATH,"//button[@type='submit']").click();
        //Step 6: Verify that login is succeed
        browser.errorChecking("Your username is invalid!");
        browser.close();
    }
}