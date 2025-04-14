package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import static com.shoppy.com.utils.PropertiesManager.webConfig;

public class FirefoxDriverFactory extends DriverAbstract
{

    @Override
    public WebDriver startDriver() {
        boolean isHeadless = webConfig.getProperty("HeadlessMode").equalsIgnoreCase("true");
        FirefoxOptions options = BrowserOptionsFactory.getFirefoxOptions(isHeadless);
        driver = new FirefoxDriver(options);
        return driver;
    }
}
