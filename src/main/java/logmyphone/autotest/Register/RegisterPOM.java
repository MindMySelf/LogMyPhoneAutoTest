package logmyphone.autotest.Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM {
    private WebDriver driver;
    @FindBy(id = "companyName")
    private WebElement nameField;
    @FindBy(id = "companyName-helper-text")
    private WebElement nameErrorText;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "email-helper-text")
    private WebElement emailErrorText;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "password-helper-text")
    private WebElement passwordErrorText;
    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;
    @FindBy(id = "confirmPassword-helper-text")
    private WebElement confirmPasswordErrorText;
    @FindBy(xpath = "//button[className='css-1vhaqj4-MuiButtonBase-root-MuiButton-root'][text()='Register']")
    private WebElement registerButton;
    @FindBy(linkText = "Already have an account? Sign In")
    private WebElement signInButton;
    @FindBy(linkText = "logmyphones.com")
    private WebElement copyRightLink;

    public RegisterPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
