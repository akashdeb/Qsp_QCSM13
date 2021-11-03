package demo.actiTime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement userNameTextField;
	
	@FindBy(name="pwd")
	private WebElement passworTextField;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginButton;
	
	@FindBy(xpath="//td[text()='Please identify yourself']")
	private WebElement headText;
	
	@FindBy(xpath="//table[@id='demoCredentials']")
	private WebElement credentials;

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public void setUserNameTextField(WebElement userNameTextField) {
		this.userNameTextField = userNameTextField;
	}

	public WebElement getPassworTextField() {
		return passworTextField;
	}

	public void setPassworTextField(WebElement passworTextField) {
		this.passworTextField = passworTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	
	//Business Logic
	public void login(String username, String password) {
		getUserNameTextField().sendKeys(username);
		getPassworTextField().sendKeys(password);
		getLoginButton().click();
	}
	public void getDetails() {
		System.out.println(headText.getText());
		System.out.println(credentials.getText());

		
	}
		
	
	}
	

