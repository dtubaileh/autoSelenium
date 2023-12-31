import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage.CheckoutPage;
import pages.Home.HomePage;
import pages.Signin.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("http://automationpractice.com");
        HomePage homePage = new HomePage();
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.goToCheckout();

        SignInPage signInPage = new SignInPage();
        signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));

        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankWire();
        checkoutPage.confirmFinalOrder();
        if(checkoutPage.checkFinalStatus())
            System.out.println("Test case completed!");
    }
}
