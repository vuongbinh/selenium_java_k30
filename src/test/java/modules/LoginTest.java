package modules;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest{
    @DataProvider
    Object [][] credentials(){
        return new Object[][]{
                new Object[]{"tomsmith","SuperSecretPassword!","/secure"},
                new Object[]{"Tomsmith","SuperSecretPassword@","/login"},
        };
    }
    @Test(dataProvider = "credentials")
    void validateLogin(String usr,String pwd, String expectedUrl) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.open();
    loginPage.login(usr,pwd);
    Assert.assertTrue(loginPage.getCurrentURL().contains(expectedUrl));
    }
}