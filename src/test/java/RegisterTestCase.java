import actions.pageObjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static actions.TestHelper.getDriver;

public class RegisterTestCase {
    WebDriver driver;
    RegisterPageObject registerFlow;
    @BeforeMethod
    public void initDriver() {
        driver = getDriver();
        registerFlow = new RegisterPageObject(driver);
    }

    @Test
    public void registerWithValidCredentials() {
        registerFlow.openPage()
                .inputName()
                .inputEmail()
                .inputPassword()
                .confirmPassword()
                .clickJoin()
                .isRegisterSucess();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
