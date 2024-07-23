package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Task3 extends BaseTest {

    @Test
    public void task1() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");

        //“Browser Windows” başlık kontrol edilir (<h1>)
        String expectedTitle = "Browser Windows";
        String actualTitle = driver.findElement(By.xpath("//h1[text()='Browser Windows']")).getText();
        System.out.println("expectedTitle=" + expectedTitle + "\nactualTitle=" + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);

        // “New Tab” butonuna tıklanır
        JavascriptExecutor newTab = (JavascriptExecutor) driver;
        newTab.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[@id='tabButton']")));
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(2000);

        //Açılan sayfanın Url’si kontrol edilir (https://demoqa.com/sample )
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/sample";
        System.out.println("expectedUrl=" + expectedUrl + "\nactualUrl=" + actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);

        //Açılan sayfadaki “This is a sample page” yazı kontrol edilir
        String expectedText = "This is a sample page";
        String actualText = driver.findElement(By.xpath("//h1[text()='This is a sample page']")).getText();
        System.out.println("expectedText=" + expectedText + "\nactualText=" + actualText);
        Assert.assertEquals(actualText, expectedText);

        driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);

        // Ana sayfaya geçilip “New Window” butonuna tıklanır
        JavascriptExecutor newWindow = (JavascriptExecutor) driver;
        newWindow.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[@id='windowButton']")));

        driver.findElement(By.xpath("//button[@id='windowButton']")).click();

        Thread.sleep(2000);

        // Açılan sayfadaki “This is a sample page” yazı kontrol edilir
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(windows.size() - 1));

        String expectedWindowText = "This is a sample page";
        WebElement sampleHeadingElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        String actualWindowText = sampleHeadingElement.getText();
        System.out.println("expectedWindowText: " + expectedWindowText + "\nactualWindowText: " + actualWindowText);
        Assert.assertEquals(actualWindowText, expectedWindowText);

        driver.switchTo().window(windows.get(0));
    }

}