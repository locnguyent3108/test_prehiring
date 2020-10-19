import actions.testFlow.LoginWorkFlow;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import org.testng.asserts.SoftAssert;

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

    @Test (priority = 2)
    public void signInWithEmailTestCase() {
        String email = "locnguyent3108+01@gmail.com";
        String password = "123456";
        loginFlow.homePage(homePageObject -> {
            homePageObject.openHomePage();
            homePageObject.clickLoginButton();

        }).loginPage(loginPageObject -> {
            loginPageObject.clickLoginWithEmail();
            loginPageObject.inputEmail(email);
            loginPageObject.inputPassword(password);
            loginPageObject.clickLogin();

            loginPageObject.isLoginSuccess();
        });
    }

    @Test(priority = 1)
    public void signInWithGmail() {
        String email = "testloc3108@gmail.com";
        String password = "Auvjdaj1992@";
        loginFlow.homePage(homePageObject -> {
            homePageObject.openHomePage();
            homePageObject.clickLoginButton();

        }).loginPage(loginPage -> {
            loginPage.clickLoginWithGmail();
            loginPage.switchToPopup();
            loginPage.inputCredentialsGmail(email, password);
            loginPage.switchBackToMainPage();

            loginPage.isLoginSuccess();

        });
    }

    @Test (priority = 2)
    public void signInWithFacebook() {
        String email = "keny_pris@yahoo.com";
        String password = "Ngocloc312592@";
        loginFlow.homePage(homePageObject -> {
            homePageObject.openHomePage();
            homePageObject.clickLoginButton();

        }).loginPage(loginPage -> {
            loginPage.clickLoginWithFacebook();
            loginPage.switchToPopup();
            loginPage.inputCredentialsFacebook(email, password);
            loginPage.switchBackToMainPage();

            loginPage.isLoginSuccess();
        });
    }

    @Test
    public void autoBuild() {
        System.out.println("hell");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
