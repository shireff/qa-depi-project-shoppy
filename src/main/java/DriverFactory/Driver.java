package DriverFactory;

import com.shoppy.com.utils.BrowserActions;
import com.shoppy.com.utils.ElementActions;
import listeners.webDriver.DriverListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import static com.shoppy.com.utils.PropertiesManager.webConfig;

public class Driver {
    private static WebDriver sharedDriver;
    private ThreadLocal<WebDriver> driver;



    public Driver() {
        String browserType = webConfig.getProperty("BrowserType");
        WebDriver undecoratedDriver = getDriver(browserType).startDriver();
        assert undecoratedDriver != null;


        driver = new ThreadLocal<>();
        driver.set(new EventFiringDecorator<>(WebDriver.class,
                new DriverListeners(undecoratedDriver)).decorate(undecoratedDriver));


        System.out.println("Start with driver: " + driver);
        driver.get().manage().window().maximize();
        String baseUrl = webConfig.getProperty("BaseURL");

        if (!baseUrl.isEmpty()) {
            driver.get().navigate().to(baseUrl);
        }

    }

    public Driver(String driverType) {
        WebDriver undecoratedDriver = getDriver(driverType).startDriver();
        assert undecoratedDriver != null;


        driver = new ThreadLocal<>();
        driver.set(new EventFiringDecorator<>(WebDriver.class,
                new DriverListeners(undecoratedDriver)).decorate(undecoratedDriver));


        System.out.println("Start with driver: " + driver);
        driver.get().manage().window().maximize();
        String baseUrl = webConfig.getProperty("BaseURL");

        if (!baseUrl.isEmpty()) {
            driver.get().navigate().to(baseUrl);
        }

    }

    private DriverAbstract getDriver(String driver) {
        switch (driver.toUpperCase()) {
            case "CHROME": {
                return new ChromeDriverFactory();
            }
            case "FIREFOX": {
                return new FirefoxDriverFactory();
            }
            case "EDGE": {
                return new EdgeDriverFactory();
            }
            default: {
                throw new IllegalStateException("Unexpected value" + driver);
            }
        }
    }

    public WebDriver get() {
        return driver.get();
    }

    public ElementActions element() {
        return new ElementActions(driver.get());
    }

    public BrowserActions browser() {
        return new BrowserActions(driver.get());
    }
}
