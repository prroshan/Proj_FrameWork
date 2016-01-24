package PageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PFLogin {
	
	@FindBy(linkText="Sign In")
	WebElement link_signin;
	
	@FindBy(name="logid")
	WebElement txt_username;
	
	@FindBy(name="pswd")
	WebElement txt_password;
	
	@FindBy(css="input[type='submit']")
	WebElement btn_login;
	
	@FindBy(className="top_cart_span")
	WebElement link_cart;
	
	@FindBy(xpath="//b[contains(text(),'Sorry we were unable to complete this step because :')]")
	WebElement login_invalidmsg;

	public void click_singin()
	{
		link_signin.click();
	}
	
	public void enter_username(String uname)
	{
		txt_username.sendKeys(uname);
	}
	
	public void enter_password(String pswd)
	{
		txt_password.sendKeys(pswd);
	}
	
	public void click_login()
	{
		btn_login.click();
	}
	
	public String extrace_invalidmsg()
	{
		return login_invalidmsg.getText();
	}
	
	public void login(String uname, String passwd)
	{
		click_singin();
		enter_username(uname);
		enter_password(passwd);
		click_login();
	}
	
	public void clik_cart()
	{
		link_cart.click();
	}
	public PFLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

}
