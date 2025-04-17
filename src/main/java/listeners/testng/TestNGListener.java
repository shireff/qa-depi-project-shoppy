package listeners.testng;

import DriverFactory.Driver;
import com.shoppy.com.utils.AllureReportHelper;
import com.shoppy.com.utils.LogHelper;
import com.shoppy.com.utils.ScreenshotManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.reflect.Field;

import static com.shoppy.com.utils.PropertiesManager.initializeProperties;
import static com.shoppy.com.utils.PropertiesManager.webConfig;

public class TestNGListener implements IExecutionListener, ITestListener {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String BLUE = "\u001B[34m";


    @Override
    public void onExecutionStart() {
        LogHelper.logInfo(CYAN + "🚀 TestNG is starting the execution" + RESET);
        initializeProperties();
        AllureReportHelper.cleanAllureReport();
    }

    @Override
    public void onExecutionFinish() {
        LogHelper.logInfo(CYAN + "📊 Generating Allure Report..." + RESET);

        if (webConfig.getProperty("openAllureReportAfterExecution").equalsIgnoreCase("true")) {
            try {
                LogHelper.logInfo(BLUE + "🔍 Opening Allure Report..." + RESET);
                Runtime.getRuntime().exec("reportGeneration.bat");
            } catch (IOException e) {
                LogHelper.logError(RED + "⚠️ Unable to open Allure Report. Please check the batch file or commands." + RESET);
            }
        } else {
            LogHelper.logInfo(YELLOW + "🛑 Allure Report not opened (check 'openAllureReportAfterExecution' config)." + RESET);
        }

        LogHelper.logInfo(GREEN + "✅ TestNG has finished the execution." + RESET);
    }


    @Override
    public void onTestStart(ITestResult result) {
        LogHelper.logInfo(BLUE + "🟢 TestNG is starting the test: " + result.getName() + RESET);
    }

    public void onTestSuccess(ITestResult result) {
        LogHelper.logInfo(BLUE + "✅ TestNG has finished the test successfully: " + result.getName() + RESET);
    }

    public void onTestFailure(ITestResult result) {
        LogHelper.logError(RED + "❌ Test Failed..........." + RESET);
        LogHelper.logError(RED + "📸 Taking Screenshot..........." + RESET);

        Driver driver = null;
        ThreadLocal<Driver> driverThreadLocal;
        Object currentClass = result.getInstance();
        Field[] fields = result.getTestClass().getRealClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType() == Driver.class) {
                    driver = (Driver) field.get(currentClass);
                }

                if (field.getType() == ThreadLocal.class) {
                    driverThreadLocal = (ThreadLocal<Driver>) field.get(currentClass);
                    driver = driverThreadLocal.get();
                }
            }
            if (driver != null && driver.get() != null) {
                ScreenshotManager.takeScreenshot(driver.get(), result.getName());
            } else {
                LogHelper.logWarn(YELLOW + "⚠️ Could not capture screenshot: driver is null" + RESET);
            }

        } catch (IllegalAccessException e) {
            LogHelper.logError(RED + "⚠️ Failed to access driver field: " + e.getMessage() + RESET);
        } catch (Exception e) {
            LogHelper.logError(RED + "💥 Unexpected error during screenshot: " + e.getMessage() + RESET);
        }
    }

    public void onTestSkipped(ITestResult result) {
        LogHelper.logInfo(YELLOW + "⏭️ TestNG has skipped the test: " + result.getName());
    }

}
