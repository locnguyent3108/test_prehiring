package actions.pageObjects;

import actions.BasePage;
import org.openqa.selenium.WebDriver;

import static helper.FakeData.*;
import static helper.GlobalConstant.BASE_URL;
import static locator.HomePageUI.*;
import static locator.RegisterUI.*;
import static org.testng.Assert.assertTrue;

public class RegisterPageObject extends BasePage {
    private static final String REGISTER_URL = BASE_URL + "register";
    private String firstName;
    private String password ;
    public RegisterPageObject(WebDriver driver) {
        super(driver);
    }

    public RegisterPageObject openPage() {
        openUrl(REGISTER_URL);
        return this;
    }

    public RegisterPageObject inputEmail() {
        waitElementReady(EMAIL_TEXTFIELD);
        click(EMAIL_TEXTFIELD);
        sendKey(EMAIL_TEXTFIELD, getEmail());
        return this;
    }

    public RegisterPageObject inputName() {
        firstName = getName();
        waitElementReady(NAME_TEXTFIELD);
        click(NAME_TEXTFIELD);
        sendKey(NAME_TEXTFIELD, firstName);
        return this;
    }

    public RegisterPageObject inputPassword() {
        password = getPassword();
        click(PASSWORD_TEXTFIELD);
        sendKey(PASSWORD_TEXTFIELD, password);
        return this;
    }

    public RegisterPageObject isRegisterSucess() {
        String locator = String.format(FIRSTNAME_LABEL, firstName);
        waitElementReady(UPCOMING_EVENT_SECTION);
        assertTrue(findElement(locator).isDisplayed());
        return this;
    }

    public RegisterPageObject confirmPassword() {
        click(CONFIRM_PASSWORD_TEXTFIELD);
        sendKey(CONFIRM_PASSWORD_TEXTFIELD, password);
        return this;
    }

    public RegisterPageObject clickJoin() {
        click(JOIN_BUTTON);
        return this;
    }
}
