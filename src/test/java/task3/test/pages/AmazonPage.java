package task3.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task3.utilities.Driver;

//düzgün görünüm için locaterları burada tanımladık
public class AmazonPage {

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "sp-cc-accept")
    public WebElement accept;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement clickButton;

    @FindBy(xpath = "//img[@data-image-index='1']")
    public WebElement firstProduct;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToCartButton;

    @FindBy(css = "a.a-button-text[data-csa-c-content-id='sw-gtc_CONTENT']")
    public WebElement goToCart;

    @FindBy(xpath = "//input[@value='Sil']")
    public WebElement delete;

    @FindBy(xpath = "//h1[contains(text(), 'Amazon sepetiniz boş')]")
    public WebElement isContains;
}