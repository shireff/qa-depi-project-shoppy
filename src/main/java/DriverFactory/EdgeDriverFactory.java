package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static com.shoppy.com.utils.PropertiesManager.webConfig;

public class EdgeDriverFactory extends DriverAbstract
{

    @Override
    public WebDriver startDriver() {
        EdgeOptions options = new EdgeOptions();
        if(webConfig.getProperty("HeadlessMode").equalsIgnoreCase("true")){
            options.addArguments("--headless");
        }
        driver = new EdgeDriver(options);
        return driver;
    }
}
