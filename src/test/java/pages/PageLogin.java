package pages;

import org.openqa.selenium.By;

import bases.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import ultils.Abstract;

public class PageLogin extends BaseTest {

    protected static PageCommon common;
	
	By txtUsername = By.cssSelector("[content-desc='Username input field']");
	By txtPwd = By.cssSelector("[content-desc='Password input field']");
	By btnLogin = By.cssSelector("[content-desc='Login button']");

    public PageLogin(AndroidDriver driver) {
    }

    public void inputUsername(String user) {
    	Abstract.setText(txtUsername, user);
    }
    
    public void inputPassword(String password) {
    	Abstract.setText(txtPwd, password);
    }
    
    public void clickLogInButton() {
    	Abstract.clickElement(btnLogin);
    }
    
    public void loginUser(String user, String pwd) {
		inputUsername(user);
		inputPassword(pwd);
		clickLogInButton();
    }
}
