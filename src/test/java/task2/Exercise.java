package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise extends BaseTest {

    @Test
    public void task4() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        WebElement clickAppointment = driver.findElement(By.id("btn-make-appointment"));
        clickAppointment.click();

        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();

        try { //otomasyonda gelmediği için try catch yapıldı test bloklanmasın diye
            driver.switchTo().alert().accept();
        } catch (Exception e) {
        }

        WebElement selectMenu = driver.findElement(By.id("combo_facility"));
        Select select = new Select(selectMenu);
        select.selectByValue("Hongkong CURA Healthcare Center");

        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.id("radio_program_medicaid")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("15/01/1999");
        driver.findElement(By.id("txt_comment")).sendKeys("comment");
        driver.findElement(By.id("btn-book-appointment")).click();
        WebElement isContains = driver.findElement(By.xpath("//h2"));

        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.xpath("//a[@href='authenticate.php?logout']")).click();
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        System.out.println("expectedUrl=" + expectedUrl + "\nactualUrl=" + actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);

        String expectedText = "We Care About Your Health";
        String actualText = driver.findElement(By.xpath("//h3[text()='We Care About Your Health']")).getText();
        System.out.println("expectedText=" + expectedText + "\nactualText=" + actualText);
        Assert.assertEquals(actualText, expectedText);

        Thread.sleep(2000);

    }
}