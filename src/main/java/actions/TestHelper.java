package actions;

import browserfactory.DriverFactory;
import browserfactory.DriverType;
import org.openqa.selenium.WebDriver;

public class TestHelper {
    public static WebDriver getDriver() {
        return DriverFactory.getDriver(DriverType.CHROME);
    }

    public static void tearDown(WebDriver driver){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
