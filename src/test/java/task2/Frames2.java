package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Frames2 extends BaseTest {

    // “Nested Frames” başlık kontrol edilir (<h1>)
    @Test
    public void task1() {
        driver.get("https://demoqa.com/nestedframes");
        String expectedTitle = "Nested Frames";
        WebElement actualTitle = driver.findElement(By.xpath("//h1[text()='Nested Frames']"));
        System.out.println("expectedTitle=" + expectedTitle + "\nactualTitle=" + actualTitle);
        Assert.assertEquals(actualTitle.getText(), expectedTitle);
    }

    //“Parent frame” yazısı kontrol edilir (büyük frame içinde)
    @Test
    public void task2() {
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        String expectedBigFrame = "Parent frame";
        WebElement actualBigFrame = driver.findElement(By.xpath("//body[text()='Parent frame']"));
        System.out.println("expectedBigFrame=" + expectedBigFrame + "\nactualBigFrame=" + actualBigFrame);
        Assert.assertEquals(actualBigFrame.getText(), expectedBigFrame);
    }

    // “Child Iframe” yazısı kontrol edilir (Büyük frame içindeki frame içinde)
    @Test
    public void task3() {
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
        String expectedSmallFrame = "Child Iframe";
        WebElement actualSmallFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        System.out.println("expectedSmallFrame=" + expectedSmallFrame + "\nactualSmallFrame=" + actualSmallFrame);
        Assert.assertEquals(actualSmallFrame.getText(), expectedSmallFrame);

    }

    //Sayfada “Sample Nested Iframe page.” texti kontrol edilir*/
    @Test
    public void task4() {
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().defaultContent();
        String expectedText = "Sample Nested Iframe page.";
        WebElement actualText = driver.findElement(By.xpath("//div[contains(text(), 'Sample')]"));
        System.out.println("expectedText=" + expectedText + "\nactualText=" + actualText);
        Assert.assertEquals(actualText.getText(), expectedText);
    }
}

/*
1)    https://demoqa.com/nestedframes Sayfasına gidilir
        2)    “Nested Frames” başlık kontrol edilir (<h1>)
        3)    “Parent frame” yazısı kontrol edilir (büyük frame içinde)
        4)    “Child Iframe” yazısı kontrol edilir (Büyük frame içindeki frame içinde)
        5)    Sayffada “Sample Nested Iframe page.” texti kontrol edilir*/
