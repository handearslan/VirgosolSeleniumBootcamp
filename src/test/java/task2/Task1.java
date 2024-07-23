package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 extends BaseTest {
    //Sayfadaki “Frames” yazısı kontrol edilir (<h1>)
    @Test
    public void task1() {
        driver.get("https://demoqa.com/frames");
        String expectedTitle = "Frames";
        WebElement actualTitle = driver.findElement(By.xpath("//h1[text()='Frames']"));
        System.out.println("expectedTitle=" + expectedTitle + "\nactualTitle=" + actualTitle);
        Assert.assertEquals(actualTitle.getText(), expectedTitle);
    }

    //“This is a sample page” yazısı kontrol edilir (Büyük frame içinde)
    @Test
    public void task2() {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        String expectedBigFrame = "This is a sample page";
        WebElement actualBigFrame = driver.findElement(By.id("sampleHeading"));
        System.out.println("expectedBigFrame=" + expectedBigFrame + "\nactualBigFrame=" + actualBigFrame);
        Assert.assertEquals(actualBigFrame.getText(), expectedBigFrame);
    }

    //“This is a sample page” yazısı kontrol edilir (küçük frame içinde)
    @Test
    public void task3() {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame2");
        String expectedSmallFrame = "This is a sample page";
        WebElement actualSmallFrame = driver.findElement(By.id("sampleHeading"));
        System.out.println("expectedSmallFrame=" + expectedSmallFrame + "\nactualSmallFrame=" + actualSmallFrame);
        Assert.assertEquals(actualSmallFrame.getText(), expectedSmallFrame);

    }

    //Sayfada “Sample Iframe page There are 2 Iframes in this page” texti kontrol edilir
    @Test
    public void task4() {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().defaultContent();
        String expectedText = "Sample Iframe page There are 2 Iframes in this page";
        WebElement actualText = driver.findElement(By.xpath("//div[contains(text(), 'Sample')]"));
        System.out.println("expectedSmallFrame=" + expectedText + "\nactualText=" + actualText);
        Assert.assertEquals(actualText.getText(), expectedText);
    }
}