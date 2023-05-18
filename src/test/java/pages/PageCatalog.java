package pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class PageCatalog {
	AndroidDriver driver;
	
	private PageCommon common;

	
	By msgLogOut = By.id("android:id/message");
	By btnLogOut = By.id("android:id/button1");
	By alertTitle = By.id("android:id/alertTitle");
	
    public PageCatalog(AndroidDriver driver) {
        this.driver = driver;
    }    
}
