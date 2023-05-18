package bases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import ultils.DriverManager;


public class BaseTest {

    protected static AndroidDriver driver;
    
    @BeforeTest
    public void startTest(final ITestContext testContext) {
        System.out.println(testContext.getName()); // it prints "Check name test"
    }
    
    @BeforeMethod()
    @Parameters({"operating"})
    public void createDriver(@Optional("android1") String operating) throws MalformedURLException {
        WebDriver driver = setupDriver(operating);
        DriverManager.setDriver(driver);
    }
    
    public static AndroidDriver setupDriver(String operatingSystem) throws MalformedURLException {
        switch (operatingSystem.trim().toLowerCase()) {
            case "android1":
                driver = initAndroid1();
                break;
            case "android2":
                driver = initAndroid2();
                break;
            default:
                System.out.println("Operating System: " + operatingSystem + " is invalid, Launching Android1 as Operating System of choice...");
                driver = initAndroid1();
        }
        return driver;
    }
    
    private static AndroidDriver initAndroid1() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "sdk_gphone_x86_64");
		desiredCapabilities.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
		desiredCapabilities.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
		desiredCapabilities.setCapability("appium:platformVersion", "13");
		desiredCapabilities.setCapability("appium:udid", "emulator-5554");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
		
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		try {
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
    
    private static AndroidDriver initAndroid2() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
		desiredCapabilities.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
		desiredCapabilities.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
		desiredCapabilities.setCapability("appium:platformVersion", "10");
		desiredCapabilities.setCapability("appium:udid", "emulator-5556");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
		
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		try {
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
    
    @AfterMethod
	public void tearDown() {
    	try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
	}
}
