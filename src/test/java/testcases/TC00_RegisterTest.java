package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.RegistrationPage;

public class TC00_RegisterTest extends BaseTest {
	HomePage hp;
	RegistrationPage rg;

	@Test(priority = 1)
	public void testhomepage() {
		logger.info("@@@@@@ Start Script@@@@@");
		hp = new HomePage(driver);
		hp.clickOnMyaccount();
		hp.clickRegister();
		Assert.assertEquals(driver.getTitle(), "Register Account");
		logger.info("@@@ After validation @@@");

	}

	@Test(priority = 2)
	public void testregister() {
		logger.info("@@Stratr Register@@@");
		rg = new RegistrationPage(driver);
		rg.setFirstName(rg.randomString());
		rg.setlastName(rg.randomString());
		rg.setEmail(rg.randomString() + "@gmail.com");
		rg.setPassword(rg.randomNumber());
		rg.clickSubscribe();
		rg.clickPrivcyPolicy();
		rg.clickSubmite();
		Assert.assertEquals(rg.getConfirmationMessage(), "Your Account Has Been Created!");
	}

}
