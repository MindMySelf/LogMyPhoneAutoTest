package logmyphone.autotest.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPOM {

    @FindBy(id = "fade-button")
    private WebElement profileButton;

    @FindBy(xpath = "/html/body/div/div/div/div/ul/li[1]/div/span")
    private WebElement dashboardMenuElement;

    @FindBy(xpath = "/html/body/div/div/div/div/ul/li[2]/div/span")
    private WebElement contactsMenuElement;

    @FindBy(xpath = "/html/body/div/div/div/div/ul/li[3]/div/span")
    private WebElement addPhoneMenuElement;

    @FindBy(xpath = "/html/body/div/div/div/div/ul/li[4]/div/span")
    private WebElement statisticsMenuElement;

    @FindBy(xpath = "/html/body/div[2]/div[3]/ul/li[2]/span")
    private WebElement logoutButton;

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public DashboardPOM(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }

    private void clickOnProfileButton(By element) {
        this.profileButton.click();
        this.wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void clickOnLogout(By element) {
        clickOnProfileButton(element);
        this.logoutButton.click();
    }

    public boolean checkVisibilityOfProfileButton() {
        return this.profileButton.isDisplayed();
    }

    public By getProfileButton() {
        return By.id("fade-button");
    }
}
