package pages.Signin;

import drivers.DriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInLocators {
    
    public SignInLocators(){
        PageFactory.initElements(DriverSingleton.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(id = "SubmitLogin")
    public WebElement signInButton;

    @FindBy(id = "email_create")
    public WebElement emailSignUpField;

    @FindBy(id = "SubmitCreate")
    public WebElement signUpButton;
}
