package actions.pageObjects;

import actions.BasePage;
import org.openqa.selenium.WebDriver;

import static helper.GlobalConstant.BASE_URL;
import static locator.HomePageUI.LOGIN_BUTTON;

public class HomePageObject extends BasePage implements PageConditions {

    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        openUrl(BASE_URL);
    }

    public void clickLoginButton() {
        click(LOGIN_BUTTON);
    }

    @Override
    public boolean isAt() {
        return findElement(LOGIN_BUTTON).isDisplayed();
    }
}

