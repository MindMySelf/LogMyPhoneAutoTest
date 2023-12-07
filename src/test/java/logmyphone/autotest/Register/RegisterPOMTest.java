package logmyphone.autotest.Register;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class RegisterPOMTest {
    private static WebDriver driver;
    private RegisterPOM registerPOM;

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
    }

    @Test
    public void successfulRegistrationTest() {
        registerPOM.addName("Tutyimutyi");
        registerPOM.addEmail("tutyimutyi@gmail.com");
        registerPOM.addPassword("MajomKenyérfa12...");
        registerPOM.addConfirmPasword("MajomKenyérfa12...");
        registerPOM.clickButton();
        assertTrue(registerPOM.isSuccessfulPopupDisplayed());
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Register/resources/RegisterName.csv")
    public void nameFieldTest() {}
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Register/resources/RegisterEmail.csv")
    public void emailFieldTest() {}
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Register/resources/RegisterPassword.csv")
    public void passwordFieldTest() {}
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Register/resources/RegisterPassword.csv")
    public void confirmPasswordFieldTest() {}
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/logmyphone/autotest/Register/resources/RegisterData.csv")
    public void allFieldTest() {}
}