package DriverFactory;

import com.shoppy.com.utils.BrowserActions;
import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.ElementAssertions;
import listeners.webDriver.DriverListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;
import java.util.Optional;
import java.util.logging.Logger;

import static com.shoppy.com.utils.PropertiesManager.webConfig;

public class Driver {
    private static final Logger logger = Logger.getLogger(Driver.class.getName());

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public Driver() {
        initializeDriver(webConfig.getProperty("BrowserType"));
    }

    public Driver(String driverType) {
        initializeDriver(driverType);
    }

    private void initializeDriver(String driverType) {
        WebDriver undecoratedDriver = Optional.ofNullable(getDriver(driverType).startDriver())
                .orElseThrow(() -> new IllegalStateException("Driver could not be started."));

        WebDriver decoratedDriver = new EventFiringDecorator<>(WebDriver.class,
                new DriverListeners(undecoratedDriver)).decorate(undecoratedDriver);

        driver.set(decoratedDriver);

        logger.info("Started with driver: " + driver.get());
        configureDriver();
    }

    private void configureDriver() {
        WebDriver currentDriver = driver.get();
        currentDriver.manage().window().maximize();

        // Configuring timeouts (implicitly wait, page load timeout, script timeout)
        currentDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        currentDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        currentDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        Optional.ofNullable(webConfig.getProperty("BaseURL"))
                .filter(url -> !url.isEmpty())
                .ifPresent(url -> currentDriver.navigate().to(url));
    }


    private DriverAbstract getDriver(String browserType) {
        switch (Optional.ofNullable(browserType).orElse("").toUpperCase()) {
            case "CHROME":
                return new ChromeDriverFactory();
            case "FIREFOX":
                return new FirefoxDriverFactory();
            case "EDGE":
                return new EdgeDriverFactory();
            default:
                throw new IllegalStateException("Unsupported browser type: " + browserType);
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

    public ElementAssertions assertion() {
        return new ElementAssertions(driver.get());
    }
}
