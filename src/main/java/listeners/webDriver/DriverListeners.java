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
    private static final Logger logger = LoggerFactory.getLogger(DriverListeners.class);

    public DriverListeners(WebDriver driver) {
        this.driver = driver;
    }

    /************************************* Browser Actions Listeners ******************************************/

    @Override
    public void afterGet(WebDriver driver, String url) {
        LogHelper.logInfo(logger,"🖥️ Getting to \"" + url + "\".");

    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        LogHelper.logInfo(logger,"📄 Current Page Title is: \"" + result + "\".");

    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        LogHelper.logInfo(logger,"🌐 Navigating to url \"" + url + "\".");

    }

    @Override
    public void afterBack(WebDriver.Navigation navigation) {
        LogHelper.logInfo(logger,"🔙 Navigating back.");

    }

    @Override
    public void afterForward(WebDriver.Navigation navigation) {
        LogHelper.logInfo(logger,"🔜 Navigating forward.");

    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        LogHelper.logInfo(logger,"🔄 Refreshing current page...");

    }

    @Override
    public void afterGetPageSource(WebDriver driver, String result) {
        LogHelper.logInfo(logger,"📜 Getting Page source: " + result);

    }

    @Override
    public void beforeDeleteCookie(WebDriver.Options options, Cookie cookie) {
        LogHelper.logInfo(logger,"🍪 Deleting Cookie: " + cookie + " ......");

    }

    @Override
    public void beforeDeleteAllCookies(WebDriver.Options options) {
        LogHelper.logInfo(logger,"🍪 Deleting All Cookies...");
    }

    /************************************* Element Actions Listeners ******************************************/

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        try {
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(
                            Long.parseLong(webConfig.getProperty("elementIdentificationTimeout"))))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException exception) {
            LogHelper.logError(logger,"⏳ Timeout: " + exception.getMessage() + " || " + exception.getCause().getMessage().substring(0, exception.getCause().getMessage().indexOf("\n")));
            throw exception;
        }


    }

    @Override
    public void afterClose(WebDriver driver) {
        LogHelper.logInfo(logger,"🚪 Successfully Closed Driver.");

    }

    @Override
    public void afterQuit(WebDriver driver) {
        LogHelper.logInfo(logger,"🚪 Successfully Quit Driver.");
    }

    @Override
    public void beforeClick(WebElement element) {
        LogHelper.logInfo(logger,"🔘 Wait for " + getElementName(element) + " to be clickable");


        try {
            new WebDriverWait(this.driver,
                    Duration.ofSeconds(Long.parseLong(webConfig.getProperty("actionTimeout"))))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (org.openqa.selenium.TimeoutException timeoutException) {
            LogHelper.logError(logger,"⏳ Timeout on click: " + timeoutException);
            throw timeoutException;
        }

        try {
            LogHelper.logInfo(logger,"🖱️ Click on " + getElementName(element) + ".");

        } catch (Exception throwable) {
            LogHelper.logInfo(logger,"🖱️ Click.");

        }
    }

    @Override
    public void beforeSubmit(WebElement element) {
        try {
            LogHelper.logInfo(logger,"📤 Submit " + getElementName(element) + ".");

        } catch (Exception throwable) {
            LogHelper.logInfo(logger,"📤 Submit.");
        }
    }


    @Override
    public void beforeClear(WebElement element) {
        LogHelper.logInfo(logger,"❌ Clear " + getElementName(element) + ".");

    }

    @Override
    public void afterGetAttribute(WebElement element, String name, String result) {
        try {
            LogHelper.logInfo(logger,"📝 Get Attribute \"" + name + "\" from " + getElementName(element) + ", value is \"" + result + "\".");

        } catch (Exception throwable) {
            LogHelper.logInfo(logger,"📝 Get Attribute \"" + name + "\", value is \"" + result + "\".");

        }
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        try {
            LogHelper.logInfo(logger,"📝 Get Text from " + getElementName(element) + ", text is \"" + result + "\".");

        } catch (Exception throwable) {
            LogHelper.logInfo(logger,"📝 Get Text, text is :\"" + result + "\".");

        }
    }


    // Alert
    @Override
    public void beforeSendKeys(Alert alert, String text) {
        LogHelper.logInfo(logger,"⌨️ Type \"" + text + "\" into Alert.");

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