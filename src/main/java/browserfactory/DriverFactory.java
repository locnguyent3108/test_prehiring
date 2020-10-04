package browserfactory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    // store Driver into map
    public static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<DriverType, Supplier<WebDriver>>();

    // ChromeDriver supplier
    private static final Supplier<WebDriver> chromeSupplier = () -> {
        return new ChromeDriverManager().createDriver();
    };

    // Firefox supplier
    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        return new FirefoxDriverManager().createDriver();
    };

    //put all supplier to map
    static {
        driverMap.put(DriverType.CHROME, chromeSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxSupplier);
    }

    // get driver from here
    public static final WebDriver getDriver(DriverType type) {
        return driverMap.get(type).get();
    }

}
