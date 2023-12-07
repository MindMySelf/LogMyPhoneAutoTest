package logmyphone.autotest.dashboard;

import logmyphone.autotest.Login.LoginPOM;
import logmyphone.autotest.Register.RegisterPOM;
import logmyphone.autotest.landingPage.LandingPagePOM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DashboardPOMTest {

    private static WebDriver webDriver;
    private static String url;
    private LandingPagePOM landingPagePOM;
    private RegisterPOM registerPOM;
    private LoginPOM loginPOM;
    private DashboardPOM dashboardPOM;

    @BeforeAll
    static void setupAll() {
        webDriver = new ChromeDriver();
        url = "http://localhost:3000/";
    }

    @BeforeEach
    void setup() {
        this.landingPagePOM = new LandingPagePOM(webDriver);
        this.loginPOM = new LoginPOM(webDriver);
        this.registerPOM = new RegisterPOM(webDriver);
        this.dashboardPOM = new DashboardPOM(webDriver);
    }

    @AfterEach
    void tearDownAll () {
        webDriver.quit();
    }

    @Test
    void test_logout_successful() {
        String userName = "Test Company";
        String password = "Test-123";
        String email = "test@test.com";

        // Registering phase
        this.landingPagePOM.clickOnRegisterButton();
        this.registerPOM.addName(userName);
        this.registerPOM.addEmail(email);
        this.registerPOM.addPassword(password);
        this.registerPOM.addConfirmPasword(password);
        this.registerPOM.clickButton();

        // Login phase
        this.landingPagePOM.clickOnLoginButton();
        this.loginPOM.enterEmail(email);
        this.loginPOM.enterPassword(password);
        this.loginPOM.clickSignIn();


        // Logout phase
        By profileButton = dashboardPOM.getProfileButton();
        // TODO -- fix test
        //this.dashboardPOM.clickOnLogout(profileButton);

        assertTrue(this.landingPagePOM.isDisplayedLoginButton());
    }

}