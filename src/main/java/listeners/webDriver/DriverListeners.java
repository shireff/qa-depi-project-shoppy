package listeners.webDriver;

import com.shoppy.com.utils.LogHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.shoppy.com.utils.PropertiesManager.webConfig;

public class DriverListeners implements WebDriverListener {

    private WebDriver driver;

    public DriverListeners(WebDriver driver) {
        this.driver = driver;
    }

    /************************************* Browser Actions Listeners ******************************************/

    @Override
    public void afterGet(WebDriver driver, String url) {
        LogHelper.logInfo("🖥️ Getting to \"" + url + "\".");

    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        LogHelper.logInfo("📄 Current Page Title is: \"" + result + "\".");

    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        LogHelper.logInfo("🌐 Navigating to url \"" + url + "\".");

    }

    @Override
    public void afterBack(WebDriver.Navigation navigation) {
        LogHelper.logInfo("🔙 Navigating back.");

    }

    @Override
    public void afterForward(WebDriver.Navigation navigation) {
        LogHelper.logInfo("🔜 Navigating forward.");

    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        LogHelper.logInfo("🔄 Refreshing current page...");

    }

    @Override
    public void afterGetPageSource(WebDriver driver, String result) {
        LogHelper.logInfo("📜 Getting Page source: " + result);

    }

    @Override
    public void beforeDeleteCookie(WebDriver.Options options, Cookie cookie) {
        LogHelper.logInfo("🍪 Deleting Cookie: " + cookie + " ......");

    }

    @Override
    public void beforeDeleteAllCookies(WebDriver.Options options) {
        LogHelper.logInfo("🍪 Deleting All Cookies...");
    }

    /************************************* Element Actions Listeners ******************************************/

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        try {
            if (driver == null) {
                throw new IllegalStateException("WebDriver is not initialized.");
            }

            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(
                            Long.parseLong(webConfig.getProperty("elementIdentificationTimeout"))))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException exception) {
            LogHelper.logError("⏳ Timeout: " + exception.getMessage() + " || " + exception.getCause().getMessage().substring(0, exception.getCause().getMessage().indexOf("\n")));
            throw exception;
        } catch (Exception e) {
            LogHelper.logError("Error occurred while finding element: " + e.getMessage());
            throw e;
        }
    }


    @Override
    public void afterClose(WebDriver driver) {
        LogHelper.logInfo("🚪 Successfully Closed Driver.");

    }

    @Override
    public void afterQuit(WebDriver driver) {
        LogHelper.logInfo("🚪 Successfully Quit Driver.");
    }

    @Override
    public void beforeClick(WebElement element) {
        LogHelper.logInfo("🔘 Wait for " + getElementName(element) + " to be clickable");


        try {
            new WebDriverWait(this.driver,
                    Duration.ofSeconds(Long.parseLong(webConfig.getProperty("actionTimeout"))))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (org.openqa.selenium.TimeoutException timeoutException) {
            LogHelper.logError("⏳ Timeout on click: " + timeoutException);
            throw timeoutException;
        }

        try {
            LogHelper.logInfo("🖱️ Click on " + getElementName(element) + ".");

        } catch (Exception throwable) {
            LogHelper.logInfo("🖱️ Click.");

        }
    }

    @Override
    public void beforeSubmit(WebElement element) {
        try {
            LogHelper.logInfo("📤 Submit " + getElementName(element) + ".");

        } catch (Exception throwable) {
            LogHelper.logInfo("📤 Submit.");
        }
    }


    @Override
    public void beforeClear(WebElement element) {
        LogHelper.logInfo("❌ Clear " + getElementName(element) + ".");

    }

    @Override
    public void afterGetAttribute(WebElement element, String name, String result) {
        try {
            LogHelper.logInfo("📝 Get Attribute \"" + name + "\" from " + getElementName(element) + ", value is \"" + result + "\".");

        } catch (Exception throwable) {
            LogHelper.logInfo("📝 Get Attribute \"" + name + "\", value is \"" + result + "\".");

        }
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        try {
            LogHelper.logInfo("📝 Get Text from " + getElementName(element) + ", text is \"" + result + "\".");

        } catch (Exception throwable) {
            LogHelper.logInfo("📝 Get Text, text is :\"" + result + "\".");

        }
    }


    // Alert
    @Override
    public void beforeSendKeys(Alert alert, String text) {
        LogHelper.logInfo("⌨️ Type \"" + text + "\" into Alert.");

    }

    private String getElementName(WebElement element) {
        String accessibleName = element.getAccessibleName();
        if ("".equals(accessibleName)) {
            return "element";
        } else {
            return "\"" + accessibleName + "\"";
        }
    }


}