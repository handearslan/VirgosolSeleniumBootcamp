package task3.test.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task3.test.pages.AmazonPage;
import task3.utilities.BrowserUtils;
import task3.utilities.ConfigurationReader;
import task3.utilities.Driver;

public class Amazon extends BaseTest {
    AmazonPage amazonPage = new AmazonPage();

    @Test
    public void task() {

        //https://www.amazon.com.tr/ sayfasına git.
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //Ana Sayfada çerezleri kabul et butonuna tıkla.
        amazonPage.accept.click();

        //Ana Sayfada searchbox kısmına Bilgisayar gir.
        amazonPage.searchBox.sendKeys("Bilgisayar");

        //Ana Sayfada Ara butonuna tıkla.
        amazonPage.clickButton.click();

        //Ürünler Sayfasında ilk ürüne tıkla.
        amazonPage.firstProduct.click();

        //Ürünler Sayfasında Sepete Ekle butonuna tıkla.
        amazonPage.addToCartButton.click();

        //Ürünler Sayfasında Sepete Git butonuna tıkla.
        amazonPage.goToCart.click();

        //Alışveriş Sepeti Sayfasında ürünü silmek için Sil butonuna tıkla.
        amazonPage.delete.click();

        BrowserUtils.sleep(2);
        //Alışveriş Sepeti Sayfasında "Amazon sepetiniz boş." yazısını kontrol et.
        Assertions.assertEquals("Amazon sepetiniz boş.", amazonPage.isContains.getText());

    }
}// testNG= Assert  log4j =Assettions