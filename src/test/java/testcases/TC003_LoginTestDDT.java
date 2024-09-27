package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utilities.DataProviders;

// Data valid-->login success --testcases pass-->logout
// Data valid login faild-->testcases faild

//Data invalid  login sucess -->test fail
// Data invalid  login faild-->test pass

public class TC003_LoginTestDDT extends BaseTest {

	LoginPage lp;
	HomePage hp;
	MyAccountPage macc;

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)

	public void testlogin(String username, String password, String exp) {
		hp = new HomePage(driver);
		hp.clickOnMyaccount();
		hp.presslogin();
		lp = new LoginPage(driver);
		lp.setEmailAdress(username);
		lp.setpassword(password);
		lp.clickLogin();
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();

		if (exp.equalsIgnoreCase("Valid")) {
			if (targetpage == true) {
				Assert.assertTrue(true);
				macc.clickLogout();

			} else {
				Assert.assertTrue(false);
			}
			

		}if (exp.equalsIgnoreCase("invalid")) {
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}


	}

}
