package scripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bases.BaseTest;
import pages.PageCommon;
import pages.PageLogin;
import ultils.Abstract;

public class MobileTest extends BaseTest {

	protected static PageLogin objPageLogin;
    protected static PageCommon common;
	
    @BeforeClass
	public static void setUpDriver() {
    	Abstract.logConsole("Set up driver");
		objPageLogin = new PageLogin(driver);
		common = new PageCommon(driver);
	}
	
    @DataProvider(name = "user")
    public Object[][] dataHRM() {
        return new Object[][]{{"bob@example.com", "10203040"}};
    }
    
	@Test(dataProvider = "user")
	public void loginUser(String username, String password) throws InterruptedException {
		common.openOptionMenu();
		common.openLogIn();
		objPageLogin.loginUser(username, password);
		common.openLogOutUserPopup();
		common.verifyLogOutQuestionMsg();
		common.logOutUser();
		common.verifyLogOutSuccessfully();
		common.closeConfirmLogOutUserPopup();
	}
	
	@Test
	public void loginUser123() throws InterruptedException {
		common.openOptionMenu();
		common.openLogIn();
		objPageLogin.loginUser("bob@example.com", "10203040");
		common.openLogOutUserPopup();
		common.verifyLogOutQuestionMsg();
		common.logOutUser();
		common.verifyLogOutSuccessfully();
		common.closeConfirmLogOutUserPopup();
	}
}