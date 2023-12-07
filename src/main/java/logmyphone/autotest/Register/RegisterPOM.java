package logmyphone.autotest.Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM {
    private WebDriver driver;
    @FindBy(id = "companyName")
    private WebElement nameField;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;
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
