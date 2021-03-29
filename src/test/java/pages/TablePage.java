package pages;

import modules.WebTableTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Person;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TablePage extends BasePage {
    static List<Person> persons;
    public TablePage(WebDriver driver) {
        super(driver);
    }

    By row = By.xpath("//table[@id='table1']/tbody/tr");


    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(row);
        persons = rows
                .stream()
                .map(WebTableTest::toPerson)
                .collect(Collectors.toList());
    }

    public float getMaxDue(){
        return persons.stream()
                .max(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new).getDue();
    }

    public float getMinDue(){
        return persons.stream()
                .min(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new).getDue();
    }

    public boolean getResult(String perName, float Due) {

        return persons.stream()
                .filter(person -> person.getDue()==Due)
                .anyMatch(person -> person.getFullName().contains(perName));
    }


}
