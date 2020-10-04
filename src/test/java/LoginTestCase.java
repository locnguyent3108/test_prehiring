import actions.testFlow.LoginWorkFlow;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static actions.TestHelper.getDriver;

public class LoginTestCase {
    WebDriver driver;
    LoginWorkFlow loginFlow;

    @BeforeMethod
    public void initDriver() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);

        driver = getDriver();
        loginFlow = new LoginWorkFlow(driver);
    }

    @Test
    public void signInWithEmailTestCase() {
        loginFlow.homePage(homePageObject -> {
            homePageObject.openHomePage();
            homePageObject.clickLoginButton();

        }).loginPage(loginPageObject -> {
            loginPageObject.clickLoginWithEmail();
            loginPageObject.inputEmail("locnguyent3108+01@gmail.com");
            loginPageObject.inputPassword("123456");
            loginPageObject.clickLogin();

            loginPageObject.isLoginSuccess();
        });
    }

    @Test
    public void signInWithGmail() {
        loginFlow.homePage(homePageObject -> {
            homePageObject.openHomePage();
            homePageObject.clickLoginButton();

        }).loginPage(loginPage -> {
            loginPage.clickLoginWithGmail();
            loginPage.switchToPopup();
            loginPage.inputCredentialsGmail("testloc3108@gmail.com", "Auvjdaj1992@");
            loginPage.switchBackToMainPage();

            loginPage.isLoginSuccess();

        });
    }

    @Test
    public void signInWithFacebook() {
        loginFlow.homePage(homePageObject -> {
            homePageObject.openHomePage();
            homePageObject.clickLoginButton();

        }).loginPage(loginPage -> {
            loginPage.clickLoginWithFacebook();
            loginPage.switchToPopup();
            loginPage.inputCredentialsFacebook("keny_pris@yahoo.com", "Ngocloc312592@");
            loginPage.switchBackToMainPage();

            loginPage.isLoginSuccess();

        });
    }

    @AfterMethod
    public void tearDown() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id);

        driver.quit();
    }
}
