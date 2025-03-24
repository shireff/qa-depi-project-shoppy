package DriverFactory;

import com.shoppy.com.utils.BrowserActions;
import com.shoppy.com.utils.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver
{
    private WebDriver driver;

    public Driver(WebDriver driver)
    {
        this.driver = driver;
    }
    private DriverAbstract getDriver(String driver)
    {
        switch (driver.toUpperCase())
        {
            case "CHROME":
            {
                return new ChromeDriverFactory();
            }
            case "FIREFOX":
            {
                return new FirefoxDriverFactory();
            }
            case "EDGE":
            {
                return  new EdgeDriverFactory();
            }
            default:
            {
                throw new IllegalStateException("Unexpected value" + driver);
            }
        }
    }
    public WebDriver get()
    {
        return driver;
    }
    public ElementActions element()
    {
        return new ElementActions(driver);
    }
    public BrowserActions browser()
    {
        return new BrowserActions(driver);
    }
}
