package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 extends BaseTest {
    @Test
    public void task3() {

        //https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html
        driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");

        //click red and green checkBoxes
        WebElement redBox = driver.findElement(By.cssSelector("input[value='red']"));
        redBox.click();

        WebElement greenBox = driver.findElement(By.cssSelector("input[value='green']"));
        greenBox.click();

        //Verify Red is selected, Orange is not selected
        WebElement orangeBox = driver.findElement(By.cssSelector("input[value='orange']"));
        Assert.assertFalse(orangeBox.isSelected(), "Orange is selected");
        Assert.assertTrue(redBox.isSelected(), "Red is not selected");

        //Verify Blue is enabled, Green is selected
        WebElement blueBox = driver.findElement(By.cssSelector("input[value='blue']"));
        Assert.assertTrue(blueBox.isEnabled(), "Blue is not enabled");
        Assert.assertTrue(greenBox.isSelected(), "Green is not selected");
    }
}