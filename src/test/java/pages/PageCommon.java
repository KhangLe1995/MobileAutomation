package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import bases.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import ultils.Abstract;

public class PageCommon extends BaseTest {
	
	By icoOptMenu = By.cssSelector("[content-desc='open menu']");
	By btnCartBadge = By.cssSelector("[content-desc='cart badge']");
	By optLogin = By.cssSelector("[content-desc='menu item log in']");
	By optLogout = By.cssSelector("[content-desc='menu item log out']");
	By lblTitlePopup = By.cssSelector("[resource-id='android:id/alertTitle']");
	By lblMsgPopup = By.cssSelector("[resource-id='android:id/message']");
	By btnLogOut = By.cssSelector("[resource-id='android:id/button1']");
	By btnOKLogOut = By.cssSelector("[resource-id='android:id/button1']");
	
	public PageCommon (AndroidDriver driver) {
    }
	
    public void openOptionMenu() {
    	Abstract.clickElement(icoOptMenu);
    }
    
    public void openCartBadge() {
    	Abstract.clickElement(btnCartBadge);
    }
    
    public void openLogIn() {
    	Abstract.clickElement(optLogin);
    }
    
    public void openLogOutUserPopup() {
    	openOptionMenu();
    	Abstract.clickElement(optLogout);
    }
    
    public void closeConfirmLogOutUserPopup() {
    	Abstract.clickElement(btnOKLogOut);
    }
    
    public void logOutUser() {
    	Abstract.waitForElementVisible(btnLogOut);
    	Abstract.clickElement(btnLogOut);
    }
    
    public void verifyLogOutQuestionMsg() {
    	Abstract.waitForElementVisible(lblMsgPopup);
		Assert.assertEquals(Abstract.getElementText(lblMsgPopup), "Are you sure you sure you want to logout?");
    }
    
    public void verifyLogOutSuccessfully() {
    	Abstract.waitForElementVisible(lblTitlePopup);
		Assert.assertEquals(Abstract.getElementText(lblTitlePopup), "You are successfully logged out.");
    }
    
}
