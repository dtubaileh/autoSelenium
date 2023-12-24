package pages.Home;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;
import utils.Utils;


public class HomePage {
    private final WebDriver driver;
    private final HomeLocators homeLocators;

    public HomePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        homeLocators = new HomeLocators();
    }


    public Boolean searchElement(String searchStr){
        homeLocators.searchBar.sendKeys(searchStr);
        homeLocators.searchButton.click();
        try {
            if(homeLocators.searchResults.isEnabled())
                return true;
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(homeLocators.signInButton));
        homeLocators.signInButton.click();
    }

    public String getUserName() {
        return homeLocators.username.getText();
    }

    public void addFirstElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(homeLocators.firstElement).build().perform();
        homeLocators.addToCartFirst.click();
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(homeLocators.continueShoppingButton));
        homeLocators.continueShoppingButton.click();
        if (homeLocators.cart.getText().contains(Constants.CART_QUANTITY))
            System.out.println("Cart has been updated");
        else {
            System.out.println("Cart has not been updated");
            Utils.takeScreenshot();
        }

    }

    public void addSecondElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(homeLocators.secondElement).build().perform();
        homeLocators.addToCartSecond.click();
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(homeLocators.proceedToCheckoutButton));
        homeLocators.proceedToCheckoutButton.click();
    }
}


