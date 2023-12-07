package logmyphone.autotest.DashboardPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard {

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

    public Dashboard(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }
}
