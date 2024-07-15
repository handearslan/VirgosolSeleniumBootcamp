package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 extends BaseTest {

    @Test
    public void task1() throws InterruptedException {

        //Go to https://petstore.octoperf.com/actions/Catalog.action
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");

        //Enter “fish” in inputBox and click “search” box
        WebElement element = driver.findElement(By.name("keyword"));
        element.sendKeys("fish");
        driver.findElement(By.name("searchProducts")).click();

        //Verify product ID is “FI-FW-02”
        String expectedID = "FI-FW-02";
        WebElement actualResult = driver.findElement(By.xpath("//font[text()=' FI-FW-02 ']"));  //text oldugu için @ yok
        String actualId = actualResult.getText();
        Assert.assertEquals(expectedID, actualId, "Beklenen sonuç değil");

        Thread.sleep(2000);
    }
}