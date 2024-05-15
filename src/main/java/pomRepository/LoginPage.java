package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement emailTextField;
	
	@FindBy(id = "password")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[text()='Registered successfully']")
	private WebElement registredSuccessfullyMsg;
	
	@FindBy(xpath = "//div[text()='Signin successful']")
	private WebElement signInSuccessfullyMsg;
	
	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	

	public WebElement getRegistredSuccessfullyMsg() {
		return registredSuccessfullyMsg;
	}

	public WebElement getSignInSuccessfullyMsg() {
		return signInSuccessfullyMsg;
	}

	public void loginAction(String email, String password) {
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
	public boolean verifyRegisterUser() {
		return registredSuccessfullyMsg.isDisplayed();
	}
	
	public boolean verifyLoginUser() {
		return signInSuccessfullyMsg.isDisplayed();
	}

}
