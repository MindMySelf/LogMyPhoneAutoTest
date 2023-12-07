package logmyphone.autotest.Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPOM {
    private WebDriver driver;
    private WebDriverWait wait;
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
    private WebElement signInLink;
    @FindBy(linkText = "logmyphones.com")
    private WebElement copyRightLink;
    @FindBy(css = ".MuiAlert-message")
    private WebElement sucessfulMessagePopup;

    public RegisterPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }
    public String addName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(nameField));
        nameField.sendKeys(name);
        return nameField.getText();
    }
    public String addEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.sendKeys(email);
        return emailField.getText();
    }
    public String addPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
        return passwordField.getText();
    }
    public String addConfirmPasword(String confpassword) {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordField));
        confirmPasswordField.sendKeys(confpassword);
        return confirmPasswordField.getText();
    }
    public void clickButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }
    public boolean isNameErrorDisplayed() {
        return nameErrorText.isDisplayed();
    }
    public boolean isEmailErrorDisplayed() {
        return emailErrorText.isDisplayed();
    }
    public boolean isPasswordErrorDisplayed() {
        return passwordErrorText.isDisplayed();
    }
    public boolean isConfirmPasswordErrorDisplayed() {
        return confirmPasswordErrorText.isDisplayed();
    }
    public void clickSignInLink() {
        signInLink.click();
    }
    public void clickCopyRightLink() {
        copyRightLink.click();
    }
    public boolean isSuccessfulPopupDisplayed() {
        return sucessfulMessagePopup.isDisplayed();
    }
}
