package ultils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import bases.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import ultils.logs.Log;

public class Abstract extends BaseTest {
	private static int TIMEOUT = 10;
    private static double STEP_TIME = 0.5;
	
	public Abstract (AndroidDriver driver) {
    }
	
	 public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logConsole(Object message) {
        Log.info(message);
    }

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }
    
    public static WebElement setDynamicElement(String string, Object... args) {
    	string = String.format(string, args);
    	By by = By.xpath(string);
    	waitForElementVisible(by);
        return driver.findElement(by);
    }

    public static Boolean checkElementExist(By by) {
    	 waitForElementVisible(by);
         sleep(2);
         List<WebElement> listElement = getWebElements(by);
         if (listElement.size() > 0) {
        	 logConsole("checkElementExist: " + true + " --- " + by);
             return true;
         } else {
        	 logConsole("checkElementExist: " + false + " --- " + by);
             return false;
         }
    }

    public static void clickElement(By by) {
        waitForElementVisible(by);
        sleep(STEP_TIME);
        getWebElement(by).click();
        logConsole("Click element: " + by);
    }

    public static void clickElement(By by, long timeOut) {
    	waitForElementVisible(by, timeOut);
        sleep(STEP_TIME);
        getWebElement(by).click();
        logConsole("Click element: " + by);
    }

    public static void setText(By by, String value) {
    	waitForElementVisible(by);
        sleep(STEP_TIME);
        getWebElement(by).clear();
        getWebElement(by).sendKeys(value);
        logConsole("Set text: " + value + " on element " + by);
    }

    public static String getElementText(By by) {
    	waitForElementVisible(by);
        sleep(STEP_TIME);
        String text = getWebElement(by).getText();
        logConsole("Get text: " + text);
        return text;
    }
    
    public static ArrayList<String> getElementsText(By by) {
    	waitForElementVisible(by);
        sleep(STEP_TIME);
        List <WebElement> listElements = getWebElements(by);
        ArrayList <String> array = new ArrayList <String>();
        for (WebElement element : listElements) {
        	array.add(element.getText());
        }
        logConsole("Get array: " + array);
        return array;
    }

	public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementVisible(By by, long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Element not exist. " + by.toString());
            logConsole("Element not exist. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by, long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Element not exist. " + by.toString());
            logConsole("Element not exist. " + by.toString());
        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            logConsole("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    public static void waitForElementClickable(By by, long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            logConsole("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

//    /**
//     * Wait for Page loaded
//     * Chờ đợi trang tải xong (Javascript tải xong)
//     */
//    public static void waitForPageLoaded() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        //Wait for Javascript to load
//        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return js.executeScript("return document.readyState").toString().equals("complete");
//            }
//        };
//        //Check JS is Ready
//        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");
//        //Wait Javascript until it is Ready!
//        if (!jsReady) {
//            System.out.println("Javascript is NOT Ready.");
//            //Wait for Javascript to load
//            try {
//                wait.until(jsLoad);
//            } catch (Throwable error) {
//                error.printStackTrace();
//                Assert.fail("FAILED. Timeout waiting for page load.");
//            }
//        }
//    }
}
