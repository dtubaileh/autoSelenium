package pages.CheckoutPage;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

public class CheckoutPage {
    private final WebDriver driver;
    private final CheckoutLocators checkoutLocators;

    public CheckoutPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        checkoutLocators = new CheckoutLocators();
    }



    public Boolean checkTitle(String title){
        return checkoutLocators.pageTitle.getText().equals(title);
    }

    public void goToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutLocators.checkoutButtonSummary));
        checkoutLocators.checkoutButtonSummary.click();
    }

    public void confirmAddress(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutLocators.checkoutButtonConfirmAddress));
        checkoutLocators.checkoutButtonConfirmAddress.click();
    }

    public void confirmShipping(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutLocators.checkoutButtonConfirmShipping));
        checkoutLocators.confirmShippingCheckBox.click();
        checkoutLocators.checkoutButtonConfirmShipping.click();
    }

    public void payByBankWire(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutLocators.payByBankWireOption));
        checkoutLocators.payByBankWireOption.click();
    }

    public void confirmFinalOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutLocators.confirmOrder));
        checkoutLocators.confirmOrder.click();
    }

    public Boolean checkFinalStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutLocators.orderConfirmationMessage));
        return checkoutLocators.orderConfirmationMessage.getText().contains(Constants.COMPLETE_ORDER);
    }

    public String getSummaryProductsString(){
        return checkoutLocators.summaryProducts.getText();
    }
}
