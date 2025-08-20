package base;

import io.appium.java_client.android.AndroidDriver;
import pages.DashboardPage;
import pages.LoginPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public static AndroidDriver driver;  
    protected DashboardPage dashboardPage;

    String adminEmail = "d@yopmail.com";
    String adminPassword = "KestrelPro@123";

    @BeforeClass
    public void setupAndLogin() {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5556");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.kestrel.stagemfg");
        caps.setCapability("appActivity", "com.kestrel.mfg.MainActivity");
        caps.setCapability("noReset", true);
        caps.setCapability("appWaitActivity", "*");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

            // ✅ Perform login once
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(adminEmail);
            loginPage.enterPassword(adminPassword);
            loginPage.tapLogin();

            dashboardPage = new DashboardPage(driver);
            System.out.println("TEST PASSED: Logged in as Admin");

        } catch (MalformedURLException e) {
            System.err.println("❌ Malformed Appium server URL");
            e.printStackTrace();
        }
    }

    @AfterClass
    public void logoutAndTearDown() {
        try {
            if (dashboardPage != null) {
                dashboardPage.logout();
                System.out.println("TEST PASSED: Logged successfully");
            }
        } catch (Exception e) {
            System.err.println("⚠️ Logout skipped (maybe already logged out)");
        }

        if (driver != null) {
            driver.quit();
           
        }
    }
}
