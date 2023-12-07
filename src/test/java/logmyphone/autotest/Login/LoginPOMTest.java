package logmyphone.autotest.Login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPOMTest {
    private static final String URL = "localhost:3000";
    private WebDriver driver;
    private LoginPOM login;

    @BeforeEach
    void setup() {
        driver = new FirefoxDriver();
        login = new LoginPOM(driver);
        driver.get(URL);
    }

    @ParameterizedTest
    @CsvFileSource(files = "", numLinesToSkip = 1)
    void testLogin() {

    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
