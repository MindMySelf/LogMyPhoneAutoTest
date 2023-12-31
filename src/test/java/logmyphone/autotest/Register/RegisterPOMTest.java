package logmyphone.autotest.Register;

import logmyphone.autotest.landingPage.LandingPagePOM;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class RegisterPOMTest {
    private static WebDriver driver;
    private RegisterPOM registerPOM;
    private LandingPagePOM landingPagePOM;

    @BeforeAll
    static void beforeAll() {
        driver = new ChromeDriver();
    }
    @AfterAll
    static void afterAll() {
        driver.close();
    }
    @BeforeEach
    void beforeEach() {
        registerPOM = new RegisterPOM(driver);
        landingPagePOM = new LandingPagePOM(driver);
        driver.get("http://localhost:3000/");
        landingPagePOM.clickOnRegisterButton();
    }

    @Test
    public void successfulRegistrationTest() throws InterruptedException {
        registerPOM.addName("Tutyimutyi");
        registerPOM.addEmail("tutyimutyi@gmail.com");
        registerPOM.addPassword("MajomKenyérfa12...");
        registerPOM.addConfirmPasword("MajomKenyérfa12...");
        registerPOM.clickButton();
        assertTrue(registerPOM.isSuccessfulPopupDisplayed());
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Register/resources/RegisterName.csv")
    public void nameFieldTest(String name) {
        registerPOM.addName(name);
        assertTrue(registerPOM.isNameErrorDisplayed());
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Register/resources/RegisterEmail.csv")
    public void emailFieldTest(String email) {
        registerPOM.addEmail(email);
        assertTrue(registerPOM.isEmailErrorDisplayed());
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Register/resources/RegisterPassword.csv")
    public void passwordFieldTest(String password) {
        registerPOM.addPassword(password);
        assertTrue(registerPOM.isPasswordErrorDisplayed());
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Register/resources/RegisterConfirmPassword.csv")
    public void confirmPasswordFieldTest(String password, String confirmPassword) {
        registerPOM.addPassword(password);
        registerPOM.addConfirmPasword(confirmPassword);
        assertTrue(registerPOM.isConfirmPasswordErrorDisplayed());
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Register/resources/RegisterData.csv")
    public void allFieldTest() {}
}