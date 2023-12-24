package pages.Signin;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class SignInPage {
    private final SignInLocators signInLocators;

    public SignInPage(){
        WebDriver driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        signInLocators = new SignInLocators();
    }



    public void logIn(String email, String passwd){
        signInLocators.emailField.sendKeys(email);
        signInLocators.password.sendKeys(passwd);
        signInLocators.signInButton.click();
    }

    public void signUp(String email){
        signInLocators.emailSignUpField.sendKeys(email);
        signInLocators.signUpButton.click();
    }

}
