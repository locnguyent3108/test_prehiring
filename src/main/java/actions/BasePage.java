package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {
    public static WebDriver driver;
    WebElement element;
    WebDriverWait wait;
    public String parentWindow;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    //=================== ACTIONS ===================
    //----- get element
    private static By byXpath(String locator) {
        return By.xpath(locator);
    }

    public static WebElement findElement(String locator) {
        return driver.findElement(byXpath(locator));
    }

    public List<WebElement> findElements(String locator) {
        return driver.findElements(byXpath(locator));
    }



    public void openUrl(String urlValue) {
        driver.get(urlValue);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void back() {
        driver.navigate().back();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void forward() {
        driver.navigate().refresh();
    }

    // Alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendTextToAlert(String textValue) {
        driver.switchTo().alert().sendKeys(textValue);
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    // browser and window handle
    public void switchWindowByID(String parentID) {
        Set<String> listWindow = driver.getWindowHandles();
        for (String window: listWindow) {
            if(window.equalsIgnoreCase(parentID)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void switchWindowByTitle(String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            driver.switchTo().window(runWindow);
            String currentWinTitle = driver.getTitle();
            if (currentWinTitle.equals(title)) {
                break;
            }
        }
    }

    public void switchToChildWindow() {
        parentWindow = driver.getWindowHandle();
        Set<String> listWindow = driver.getWindowHandles();
        Iterator<String> listWindowHandle = listWindow.iterator();

        while (listWindowHandle.hasNext()){
            String childWindow = listWindowHandle.next();

            if(!childWindow.equals(parentWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

    // Built in function
    public void click(String locator) {
        findElement(locator).click();
    }

    public void sendKey(String locator, String value) {
        WebElement el = findElement(locator);
        el.sendKeys(value);
    }

    public boolean isSelectecd(WebElement e) {
        return e.isSelected();
    }

    public void tickToCheckBox(String locator) {
        element = findElement(locator);
        if(!element. isSelected()) {
            element.click();
        }
    }

    public void unTickToCheckBox(String locator) {
        element = findElement(locator);
        if(element.isSelected()) {
            element.click();
        }
    }

    public String getTextElement(String locator) {
        return findElement(locator).getText();
    }

    public void clearText(String locator) {
        element = findElement(locator);
        element.clear();
    }

    public void selectValueInDropdown(String locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }

    public String getTextCurrentDropdown(String locator) {
        Select select = new Select(findElement(locator));
        return select.getFirstSelectedOption().getText();
    }

    public void switchToFrame(String locator) {
        driver.switchTo().frame(findElement(locator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void waitElementReady(String locator) {
        wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
    }

    public void hitEnter(){
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
    }
}