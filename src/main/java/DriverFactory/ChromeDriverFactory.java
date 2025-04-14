package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static com.shoppy.com.utils.PropertiesManager.webConfig;

public class ChromeDriverFactory extends DriverAbstract {

    @Override
    public WebDriver startDriver() {
        boolean isHeadless = webConfig.getProperty("HeadlessMode").equalsIgnoreCase("true");
        ChromeOptions options = BrowserOptionsFactory.getChromeOptions(isHeadless);
        driver = new ChromeDriver(options);
        return driver;
    }
}
