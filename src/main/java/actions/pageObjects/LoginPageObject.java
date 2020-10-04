package actions.pageObjects;

import actions.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

import static locator.HomePageUI.UPCOMING_EVENT_SECTION;
import static locator.LoginPageUI.*;
import static locator.LoginPageUI.LOGIN_BUTTON;
import static org.testng.Assert.assertTrue;

public class LoginPageObject extends BasePage implements PageConditions {
    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return findElement(LOGIN_HEADER).isDisplayed();
    }

    public void inputEmail(String value) {
        waitElementReady(EMAIL_TEXTFIELD);
        sendKey(EMAIL_TEXTFIELD, value);
    }

    public void inputPassword(String value) {
        waitElementReady(PASSWORD_TEXTFIELD);
        sendKey(PASSWORD_TEXTFIELD, value);
    }

    public void clickLogin() {
        click(LOGIN_BUTTON);
    }

    public void clickLoginWithEmail() {
        waitElementReady(LOGIN_EMAIL_BUTTON);
        click(LOGIN_EMAIL_BUTTON);
    }

    Supplier<Boolean> alreadyLogin = () -> {
        return !findElement(LOGIN_BUTTON).isDisplayed();
    };

    public void isLoginSuccess() {
        waitElementReady(UPCOMING_EVENT_SECTION);
        try {
            assertTrue(alreadyLogin.get());
        } catch (Exception e) {
            System.out.println("system not login success please recheck ");
            e.printStackTrace();
        }
    }

    public void clickLoginWithGmail() {
        waitElementReady(LOGIN_GMAIL_BUTTON);
        click(LOGIN_GMAIL_BUTTON);
    }

    public void switchToPopup() {
        switchToChildWindow();
    }

    public void switchBackToMainPage() {
        switchWindowByID(parentWindow);
    }

    public void inputCredentialsGmail(String userName, String password) {
        inputEmailGmail(userName);
        inputPasswordGmail(password);

    }

    public void inputEmailGmail(String value) {
        waitElementReady(GMAIL_EMAIL_TEXTFIELD);
        sendKey(GMAIL_EMAIL_TEXTFIELD, value);
        waitElementReady(GMAIL_NEXT_TO_PASSWORD_TEXTFIELD);
        hitEnter();
    }

    public void inputPasswordGmail(String value) {
        waitElementReady(GMAIL_PASSWORD_TEXTFIELD);
        sendKey(GMAIL_PASSWORD_TEXTFIELD, value);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitElementReady(GMAIL_NEXT_TO_PASSWORD_TEXTFIELD);
        hitEnter();
    }

    public void clickLoginWithFacebook() {
        waitElementReady(LOGIN_FACEBOOK_BUTTON);
        click(LOGIN_FACEBOOK_BUTTON);
    }

    public void inputCredentialsFacebook(String userName, String password) {
        inputFacebookEmail(userName);
        inputFacebookPassword(password);
        clickLoginInPopUp();
    }

    public void inputFacebookEmail(String value) {
        waitElementReady(LOGIN_FACEBOOK_EMAIL);
        sendKey(LOGIN_FACEBOOK_EMAIL, value);
    }

    public void inputFacebookPassword(String value) {
        waitElementReady(LOGIN_FACEBOOK_PASSWORD);
        sendKey(LOGIN_FACEBOOK_PASSWORD, value);
    }

    public void clickLoginInPopUp() {
        waitElementReady(LOGIN_FACEBOOK_POPUP_BUTTON);
        click(LOGIN_FACEBOOK_POPUP_BUTTON);
    }
}
