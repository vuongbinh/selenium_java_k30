package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TablePage;
import support.Person;

import java.util.List;

public class WebTableTest extends BaseTest{

    @DataProvider Object[][] dataMaxDue(){
        return new Object[][]{
                new Object[]{"Jason Doe",true},
                new Object[]{"Frank Bach",false},
                new Object[]{"John Smith",false},
                new Object[]{"Tim Conway",false}
        };
    }
    @Test(dataProvider = "dataMaxDue")
    void personWhohasMaxDue(String perName, boolean expected){
        TablePage tablePage = new TablePage(driver);
        tablePage.open();
        float maxDue = tablePage.getMaxDue();

        Assert.assertEquals(tablePage.getResult(perName,maxDue),expected);
    }
    @DataProvider Object[][] dataMinDue(){
        return new Object[][]{
                new Object[]{"Jason Doe",false},
                new Object[]{"Frank Bach",false},
                new Object[]{"John Smith",true},
                new Object[]{"Tim Conway",true}
        };
    }
    @Test(dataProvider = "dataMinDue")
    void personWhohasMinDue(String perName, boolean expected){
        TablePage tablePage = new TablePage(driver);
        tablePage.open();
        float minDue = tablePage.getMinDue();
        Assert.assertEquals(tablePage.getResult(perName,minDue),expected);
    }

    public static Person toPerson(WebElement row){
        List<WebElement> cells = row.findElements(By.tagName("td"));
        String lastName = cells.get(0).getText();
        String firstName = cells.get(1).getText();
        String email = cells.get(2).getText();
        String due = cells.get(3).getText().replace("$","");
        String website = cells.get(4).getText();
        return new Person(firstName,lastName,email,Float.parseFloat(due),website);
    }


}
