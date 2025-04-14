package DriverFactory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Map;

public class BrowserOptionsFactory {

    public static Map<String, Object> getCommonPrefs() {
        return Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile_enabled", false
        );
    }

    public static ChromeOptions getChromeOptions(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", getCommonPrefs());
        if (isHeadless) {
            options.addArguments("--headless");
        }
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }

    public static FirefoxOptions getFirefoxOptions(boolean isHeadless) {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("permissions.default.desktop-notification", 2);
        options.addPreference("media.navigator.permission.disabled", true);
        options.addPreference("media.navigator.streams.fake", true);
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return options;
    }

    public static EdgeOptions getEdgeOptions(boolean isHeadless) {
        EdgeOptions options = new EdgeOptions();
        if (isHeadless) {
            options.addArguments("--headless");
        }
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }
}
