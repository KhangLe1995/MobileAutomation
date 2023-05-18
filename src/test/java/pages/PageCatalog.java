package pages;

import org.openqa.selenium.By;

import bases.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class PageCatalog extends BaseTest {

    protected static PageCommon common;

	
	String lblStoreItem = "//android.widget.TextView[@content-desc='store item text' and contains(text(),'%s')]";
	By btnSort = By.xpath("//android.view.ViewGroup[@content-desc='sort button']");
	By alertTitle = By.id("android:id/alertTitle");
	
    public PageCatalog(AndroidDriver driver) {
    } 
}
