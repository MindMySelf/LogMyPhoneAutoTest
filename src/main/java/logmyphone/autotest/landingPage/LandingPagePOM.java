package logmyphone.autotest.landingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPagePOM {

    @FindBy(css = "#root > div.MuiBox-root.css-1ykdma4 > header > div > div > div.MuiBox-root.css-2uchni > button:nth-child(1)")
    private WebElement loginButton;

    @FindBy(css = "#root > div.MuiBox-root.css-1ykdma4 > header > div > div > div.MuiBox-root.css-2uchni > button:nth-child(2)")
    private WebElement registerButton;

    private final WebDriver webDriver;

    public LandingPagePOM(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnLoginButton() {
        this.loginButton.click();
    }

    public void clickOnRegisterButton() {
        this.registerButton.click();
    }
}
