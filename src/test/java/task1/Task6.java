package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Task6 extends BaseTest {

    @Test
    public void task6() throws InterruptedException {

        //Open "https://demoqa.com/select-menu".
        driver.get("https://demoqa.com/select-menu");

        //Select the Old Style Select Menu using the element id.
        WebElement element = driver.findElement(By.id("oldSelectMenu"));
        Select selectMenu = new Select(element);
        List<WebElement> options = selectMenu.getOptions();
        System.out.println("Menüsündeki seçeneklerin sayısı: " + options.size());

        //Print all the options texts of the dropdown.
        for (WebElement option : options) {
            System.out.println("Seçenek: " + option.getText());
        }

        //Select 'Purple' using the index and get text
        selectMenu.selectByIndex(4);
        String selectedText = selectMenu.getOptions().get(4).getText();
        System.out.println("Seçilen Metin(index): " + selectedText);
        Thread.sleep(2000);

        //After that, select 'Magenta' using visible text and get text
        selectMenu.selectByVisibleText("Magenta");
        String selectedTextMagenta = selectMenu.getOptions().get(9).getText(); //indexten aldık.
        System.out.println("Seçilen Metin(visible): " + selectedTextMagenta);
        Thread.sleep(2000);

        //Select an option using value of 'White' and get text
        selectMenu.selectByValue("6");
        String selectedTextWhite = selectMenu.getOptions().get(6).getText();
        System.out.println("Seçilen Metin(value): " + selectedTextWhite);
        Thread.sleep(2000);

    }
}