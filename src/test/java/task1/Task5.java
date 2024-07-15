package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Task5 extends BaseTest {

    @Test
    public void task5() throws InterruptedException {

        //go to https://selenium08.blogspot.com/2019/11/dropdown.html
        driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");

        //get size of dropdown menu
        WebElement elementMonth = driver.findElement(By.name("Month"));
        Select select = new Select(elementMonth);
        List<WebElement> options = select.getOptions(); //tüm seçeneklei ekledik.
        System.out.println("Menüsündeki seçeneklerin sayısı: " + options.size());

        //get all texts
        for (WebElement option : options) {
            System.out.println("Seçenek: " + option.getText());
        }

        //select March by value
        select.selectByValue("Ma");
        Thread.sleep(3000);

        //select April by index
        select.selectByIndex(4);
        Thread.sleep(3000);

        //select October by text
        select.selectByVisibleText("October");
        Thread.sleep(3000);

        //Verify: get selected options size=3
        List<WebElement> selectedOptions = select.getAllSelectedOptions(); //seçilen seçenekleri ekledi
        System.out.println("Seçilen seçenek sayısı: " + selectedOptions.size());
    }
}