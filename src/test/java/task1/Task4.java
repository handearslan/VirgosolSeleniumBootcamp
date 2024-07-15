package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task4 extends BaseTest {

    @Test
    public void task4() {

        //https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html
        driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");

        //click IE
        WebElement clickIE = driver.findElement(By.xpath("//input[@value='IE']"));
        clickIE.click();

        //Verify IE is selected, Opera is not selected
        WebElement opera = driver.findElement(By.xpath("//input[@value='Opera']"));
        Assert.assertTrue(clickIE.isSelected(), "IE is not selected");
        Assert.assertFalse(opera.isSelected(), "Opera is selected");

        //Click Mozilla
        WebElement clickMozilla = driver.findElement(By.xpath("//input[@value='Mozilla']"));
        clickMozilla.click();

        //Verify Mozilla is selected, IE is not selected
        Assert.assertTrue(clickMozilla.isSelected(), "Mozilla is not selected");
        Assert.assertFalse(clickIE.isSelected(), "IE is selected");
    }
}