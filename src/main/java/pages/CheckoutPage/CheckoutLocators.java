package pages.CheckoutPage;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutLocators {
    public CheckoutLocators(){
        WebDriver webDriver = DriverSingleton.getDriver();
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(css = "head > title")
    public WebElement pageTitle;

    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")
    public WebElement checkoutButtonSummary;

    @FindBy(css = "#center_column > form > p > button > span")
    public WebElement checkoutButtonConfirmAddress;

    @FindBy(id = "cgv")
    public WebElement confirmShippingCheckBox;

    @FindBy(css = "#form > p > button > span")
    public WebElement checkoutButtonConfirmShipping;

    @FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
    public WebElement payByBankWireOption;

    @FindBy(css = "#cart_navigation > button > span")
    public WebElement confirmOrder;

    @FindBy(css = "#center_column > div > p > strong")
    public WebElement orderConfirmationMessage;

    @FindBy(id = "summary_products_quantity")
    public WebElement summaryProducts;
}
