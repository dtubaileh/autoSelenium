import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CheckoutPage.CheckoutPage;
import pages.Home.HomePage;
import pages.Signin.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;

public class BaseSetup {

    public FrameworkProperties frameworkProperties;
    public WebDriver driver;
    public HomePage homePage;
    public SignInPage signInPage;
    public CheckoutPage checkoutPage;

    @BeforeClass
    public void initializeObjects(){
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInPage = new SignInPage();
        checkoutPage = new CheckoutPage();
        //TODO: search about overrite with beforeClass
    }

    @AfterClass
    public void closeObjects(){
        driver.close();
    }
}
