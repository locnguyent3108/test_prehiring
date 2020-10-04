package actions.testFlow;

import actions.pageObjects.HomePageObject;
import actions.pageObjects.LoginPageObject;
import actions.pageObjects.PageConditions;
import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;

public class LoginWorkFlow {
    private static WebDriver driver;

    public LoginWorkFlow(WebDriver driver) {
        this.driver = driver;
    }

    //This is static to give an entry point
    public static LoginWorkFlow homePage(Consumer<HomePageObject> c) {
        HomePageObject homePageObject = new HomePageObject(driver);
        c.accept(homePageObject);
        return new LoginWorkFlow(driver);
    }

    public LoginWorkFlow loginPage(Consumer<LoginPageObject> c) {
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        this.waitForPageLoad(loginPageObject);
        c.accept(loginPageObject);
        return this;
    }

    private void waitForPageLoad(PageConditions p){
        System.out.println("------------------------------");
        System.out.println("Waiting for " + p.toString() + " to load" );
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}