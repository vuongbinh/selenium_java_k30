package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.Person;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class WebTableTest {
    static WebDriver driver;
    static List<Person> persons;

    @BeforeMethod
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        persons = rows
                .stream()
                .map(WebTableTest::toPerson)
                .collect(Collectors.toList());
    }
    @DataProvider Object[][] dataMaxDue(){
        return new Object[][]{
                new Object[]{"Jason Doe"},
                new Object[]{"Frank Bach"}
        };
    }
    @Test(dataProvider = "dataMaxDue")
    void personWhohasMaxDue(String perName){
        float maxDue = persons.stream()
                .max(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new).getDue();
        boolean result = persons.stream()
                .filter(person -> person.getDue()==maxDue)
                .anyMatch(person -> person.getFullName().contains(perName));
        Assert.assertTrue(result);
    }
    @DataProvider Object[][] dataMinDue(){
        return new Object[][]{
                new Object[]{"John Smith"},
                new Object[]{"Tim Conway"}
        };
    }
    @Test(dataProvider = "dataMinDue")
    void personWhohasMinDue(String perName){
        float minDue = persons.stream()
                .min(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new).getDue();
        boolean result = persons.stream()
                .filter(person -> person.getDue()==minDue)
                .anyMatch(person -> person.getFullName().contains(perName));
        Assert.assertTrue(result);
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
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
