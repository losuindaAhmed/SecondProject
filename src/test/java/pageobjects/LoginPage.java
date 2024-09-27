package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// locators
	

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement txtEmailAdress;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement txtpassword;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement buttonLogin;
	// Action Method

	

	public void setEmailAdress(String email) {
		txtEmailAdress.sendKeys(email);
	}

	public void setpassword(String pws) {
		txtpassword.sendKeys(pws);
	}

	public void clickLogin() {
		buttonLogin.click();
	}

}
