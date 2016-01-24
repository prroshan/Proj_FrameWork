package TestScripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import DataProviders.LoginCredentialsReader;
import GenericClass.BaseClass;
import PageObjets.PFLogin;
import junit.framework.Assert;

public class Login extends BaseClass{
	
	@Test(dataProvider="validlogin", dataProviderClass=LoginCredentialsReader.class,enabled=false)
	public void validLogin(String TCID, String Order, String uname, String passwd, String exp_res)
	{
	
		Logger log = Logger.getLogger(Login.class);
		PFLogin loginobj = new PFLogin(driver);
		
		log.info("Starting TestCase:"+ TCID);
		log.info("Signing in to the application");
		loginobj.login(uname, passwd);
		
		String actual_res = driver.findElement(By.className("proper")).getText().replaceAll(" g", "");
		log.info("Checking the user name");
		SoftAssert sassert = new SoftAssert();
		sassert.assertEquals(actual_res, exp_res);
		//Assert.assertEquals(exp_res, actual_res);
		
	}
	
	@Test(dataProvider="invalidlogin", dataProviderClass=LoginCredentialsReader.class)
	public void invalidLogin(String TCID, String Order, String uname, String passwd, String exp_res)
	{
	
		Logger log = Logger.getLogger(Login.class);
		PFLogin loginobj = new PFLogin(driver);
		
		log.info("Starting TestCase:"+ TCID);
		log.info("Signing in to the application");
		loginobj.login(uname, passwd);
		
		String actual_res = loginobj.extrace_invalidmsg();
		log.info("Checking the Error Message");
		
		Assert.assertEquals(exp_res, actual_res);
		
	}
}
