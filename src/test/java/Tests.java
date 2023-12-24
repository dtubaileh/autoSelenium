
import org.testng.annotations.Test;
import utils.Constants;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Tests extends BaseSetup {

    @Test
    public void testingAuthentication() {
        driver.get(Constants.URL);
        homePage.clickSignIn();
        signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME), homePage.getUserName());
    }

    @Test
    public void testingAddingThingsToCart() {
        driver.get(Constants.URL);
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();
        assertEquals(Constants.CART_QUANTITY_TEST, checkoutPage.getSummaryProductsString());
    }

    @Test
    public void testingTheFullBuyingProcess() {
        driver.get(Constants.URL);
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();
        checkoutPage.goToCheckout();
        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankWire();
        checkoutPage.confirmFinalOrder();
        assertTrue(checkoutPage.checkFinalStatus());
        assertThat("Test", is("Test"));
    }


}
