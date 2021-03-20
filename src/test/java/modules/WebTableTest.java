package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import support.Browsers;
import support.Person;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class WebTableTest {
    Browsers browser = new Browsers();
    @BeforeMethod
    void setup(){
        browser.open("chrome");
        browser.navigateTo("https://the-internet.herokuapp.com/tables");
    }

    @Test
     void maximumDuePerson(){

        List<WebElement> rows = browser.findMultiple(How.XPATH,"//table[@id='table1']/tbody/tr");
        List<Person> persons = rows
                .stream()
                .map(WebTableTest::toPerson)
                .collect(Collectors.toList());
        Person maxDuePerson = persons
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new);
        Assert.assertEquals(maxDuePerson.getFullName(),"Jason Doe");
    }

    @Test
    void minimumDuePerson(){
        List<WebElement> rows = browser.findMultiple(How.XPATH,"//table[@id='table1']/tbody/tr");
        List<Person> persons = rows
                .stream()
                .map(WebTableTest::toPerson)
                .collect(Collectors.toList());
        Person maxDuePerson = persons
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new);
        Assert.assertEquals(maxDuePerson.getFullName(),"John Smith");
    }

    @AfterMethod
    void tearDown(){
        browser.close();
    }
    static Person toPerson(WebElement row){
        List<WebElement> cells = row.findElements(By.tagName("td"));
        String lastName = cells.get(0).getText();
        String firstName = cells.get(1).getText();
        String email = cells.get(2).getText();
        String due = cells.get(3).getText().replace("$","");
        String website = cells.get(4).getText();
        return new Person(firstName,lastName,email,Float.parseFloat(due),website);
    }


}
