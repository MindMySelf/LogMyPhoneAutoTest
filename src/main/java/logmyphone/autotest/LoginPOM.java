package logmyphone.autotest;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPOM {

    private final WebDriverWait wait;

    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(css = "html body div.MuiModal-root.css-79ws1d-MuiModal-root div.MuiBox-root.css-1kszvuq div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation6.MuiGrid-root.MuiGrid-container.css-5by4qi-MuiPaper-root-MuiGrid-root div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-sm-7.MuiGrid-grid-md-6.css-mb8s4g-MuiGrid-root div.MuiBox-root.css-1sv93hn form.MuiBox-root.css-164r41r label.MuiFormControlLabel-root.MuiFormControlLabel-labelPlacementEnd.css-j204z7-MuiFormControlLabel-root span.MuiButtonBase-root.MuiCheckbox-root.MuiCheckbox-colorPrimary.MuiCheckbox-sizeMedium.PrivateSwitchBase-root.css-12wnr2w-MuiButtonBase-root-MuiCheckbox-root input.PrivateSwitchBase-input.css-1m9pwf3")
    private WebElement rememberMeCheckbox;

    @FindBy(css = "html body div.MuiModal-root.css-79ws1d-MuiModal-root div.MuiBox-root.css-1kszvuq div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation6.MuiGrid-root.MuiGrid-container.css-5by4qi-MuiPaper-root-MuiGrid-root div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-sm-7.MuiGrid-grid-md-6.css-mb8s4g-MuiGrid-root div.MuiBox-root.css-1sv93hn form.MuiBox-root.css-164r41r button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-fullWidth.css-1vhaqj4-MuiButtonBase-root-MuiButton-root")
    private WebElement signInButton;

    @FindBy(css = "html body div.MuiModal-root.css-79ws1d-MuiModal-root div.MuiBox-root.css-1kszvuq div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation6.MuiGrid-root.MuiGrid-container.css-5by4qi-MuiPaper-root-MuiGrid-root div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-sm-7.MuiGrid-grid-md-6.css-mb8s4g-MuiGrid-root div.MuiBox-root.css-1sv93hn form.MuiBox-root.css-164r41r div.MuiGrid-root.MuiGrid-container.css-11lq3yg-MuiGrid-root div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-true.css-1vd824g-MuiGrid-root a.MuiTypography-root.MuiTypography-body2.MuiLink-root.MuiLink-underlineAlways.css-101ca9i-MuiTypography-root-MuiLink-root")
    private WebElement forgotPasswordLink;

    @FindBy(css = "html body div.MuiModal-root.css-79ws1d-MuiModal-root div.MuiBox-root.css-1kszvuq div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation6.MuiGrid-root.MuiGrid-container.css-5by4qi-MuiPaper-root-MuiGrid-root div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-sm-7.MuiGrid-grid-md-6.css-mb8s4g-MuiGrid-root div.MuiBox-root.css-1sv93hn form.MuiBox-root.css-164r41r div.MuiGrid-root.MuiGrid-container.css-11lq3yg-MuiGrid-root div.MuiGrid-root.MuiGrid-item.css-13i4rnv-MuiGrid-root a.MuiTypography-root.MuiTypography-body2.MuiLink-root.MuiLink-underlineAlways.css-101ca9i-MuiTypography-root-MuiLink-root")
    private WebElement signUpLink;

    public LoginPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void enterEmail(String email) {
        try {
            wait.until(ExpectedConditions.visibilityOf(emailInputField));
            emailInputField.sendKeys(email);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInputField));
            passwordInputField.sendKeys(password);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void checkRememberMe() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
            if (!rememberMeCheckbox.isSelected()) {
                rememberMeCheckbox.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void uncheckRememberMe() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
            if (rememberMeCheckbox.isSelected()) {
                rememberMeCheckbox.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void clickSignIn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(signInButton));
            signInButton.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void clickForgotPasswordLink() {
        try {
            wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink));
            forgotPasswordLink.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void clickSignUpLink() {
        try {
            wait.until(ExpectedConditions.visibilityOf(signUpLink));
            signUpLink.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
