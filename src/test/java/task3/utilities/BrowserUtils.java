package task3.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import task3.utilities.logger.Log;
//sürekli kulanacagımız metodları burada kullanıyoruz.
public class BrowserUtils {

    static Log log=new Log();
    static Actions actions=new Actions(Driver.getDriver());

    public static void sleep(int second){
        second *=1000;
        log.info("statik bekleme kullandınız.....!!!!");
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){
            log.info("Uyurkan problem oldu");
        }
    }

    public static void hover(WebElement element){
        actions.moveToElement(element).pause(1000).perform();
    }
}