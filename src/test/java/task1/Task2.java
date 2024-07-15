package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 extends BaseTest {

    @Test
    public void task2() throws InterruptedException {

        //Go to https://petstore.octoperf.com/actions/Catalog.action
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");

        //Enter “fish” in inputBox and click “search” box
        WebElement element = driver.findElement(By.name("keyword"));
        element.sendKeys("fish");
        driver.findElement(By.name("searchProducts")).click();

        //Click productID “FI-FW-02 Goldfish”
        driver.findElement(By.xpath("//font[text()=' FI-FW-02 ']")).click();
        driver.findElement(By.xpath("//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-20']")).click();

        //Click “Fish” module
        driver.findElement(By.xpath("//img[@src='../images/sm_fish.gif']")).click();

        //Click productID “FI-SW-01 Angelfish”
        driver.findElement(By.xpath("//a[@href='/actions/Catalog.action?viewProduct=&productId=FI-SW-01']")).click();

        //Select large angel fish and add to cart
        driver.findElement(By.xpath("//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-1']")).click();

        //Verify total cost “$22.00”
        String expectedResult = "Sub Total: $22.00";
        WebElement actualResult = driver.findElement(By.xpath("//*[contains(text(), 'Sub Total: $22.00')]"));
        String actual = actualResult.getText();
        Assert.assertEquals(expectedResult, actual, "Beklenen sonuç değil");

        Thread.sleep(2000);

    }
}