package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class TC002_LoginTest extends BaseTest {

	LoginPage lp;
	HomePage hp;

	@Test(groups= {"Sanity","Master"})
	
	public void testlogin() {
		hp = new HomePage(driver);
		hp.clickOnMyaccount();
		hp.presslogin();
		lp = new LoginPage(driver);
		lp.setEmailAdress(p.getProperty("EmailAdress"));
		lp.setpassword(p.getProperty("password"));
		lp.clickLogin();
		Assert.assertEquals(driver.getTitle(), "Account Login");

	}

}
