package logmyphone.autotest.Login;

import logmyphone.autotest.dashboard.DashboardPOM;
import logmyphone.autotest.landingPage.LandingPagePOM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPOMTest {
    private static final String URL = "localhost:3000";
    private WebDriver driver;
    private LandingPagePOM landingPage;
    private LoginPOM login;
    private DashboardPOM dashboard;

    @BeforeEach
    void setup() {
        driver = new FirefoxDriver();
        landingPage = new LandingPagePOM(driver);
        login = new LoginPOM(driver);
        dashboard = new DashboardPOM(driver);
        driver.get(URL);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Login/resources/loginCredentialsAndExpectations.csv", numLinesToSkip = 1)
    void testLogin(String email, String password, String dashboardVisible) {
        landingPage.clickOnLoginButton();

        login.enterEmail(email);
        login.enterPassword(password);
        login.clickSignIn();

        boolean expectedResult = dashboardVisible.equals("true");
        boolean actualResult = dashboard.checkVisibilityOfProfileButton();

        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
