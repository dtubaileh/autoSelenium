package pages.Home;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLocators {

    public HomeLocators(){
        WebDriver driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
    public WebElement addToCartFirst;

    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.last-item-of-mobile-line.hovered > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
    public WebElement addToCartSecond;

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    public WebElement cart;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
    public WebElement proceedToCheckoutButton;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")
    public WebElement continueShoppingButton;

    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line")
    public WebElement firstElement;

    @FindBy(css = "#homefeatured > li:nth-child(2)")
    public WebElement secondElement;

    @FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    public WebElement signInButton;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a > span")
    public WebElement username;

    @FindBy(id = "search_query_top")
    public WebElement searchBar;

    @FindBy(css = "#searchbox > button")
    public WebElement searchButton;

    @FindBy(css = "#center_column > ul > li > div > div.left-block > div > a.product_img_link > img")
    public WebElement searchResults;

}
