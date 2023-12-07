package logmyphone.autotest.Login;

import logmyphone.autotest.Dashboard.DashboardPOM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPOMTest {
    private static final String URL = "localhost:3000";
    private WebDriver driver;
    private LoginPOM login;
    private DashboardPOM dashboard;

    @BeforeEach
    void setup() {
        driver = new FirefoxDriver();
        login = new LoginPOM(driver);
        dashboard = new DashboardPOM(driver);
        driver.get(URL);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Login/resources/loginCredentialsAndExpectations.csv", numLinesToSkip = 1)
    void testLogin() {

    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
