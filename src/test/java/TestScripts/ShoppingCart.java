package TestScripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericClass.BaseClass;
import PageObjets.PFCart;
import PageObjets.PFLogin;
import PageObjets.PFProductPage;
import PageObjets.PFSearchBook;

public class ShoppingCart extends BaseClass {

	@Test(dataProvider="add_cart" ,dataProviderClass=DataProviders.CartDetailsReader.class)
	public void add_cart(String TC_ID,String order,String uname,String passwd,String search_txt,String qty, String exp_res)
	{
		Logger log = Logger.getLogger(ShoppingCart.class);
		PFLogin ologin = new PFLogin(driver);
		ologin.login(uname, passwd);
		if(driver.findElement(By.className("proper")).getText().replaceAll(" g", "").contains("qtpworld2008"))
		{
			Reporter.log("Logged in successfully");
			log.info("Logged in successfully");
		}else{
			Assert.fail("Login failed");
			log.error("Login failed");
		}
		
		
		PFSearchBook osearch = new PFSearchBook(driver);
		osearch.search(search_txt);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("find")));
		String act_res = osearch.extract_prod_string().toLowerCase();
		if(act_res.contains(search_txt))
		{
			Reporter.log("Book found on search");
			log.info("Book found on search");
		}else{
			Assert.fail("Book not found in search.Got:"+ act_res+ ",Expected:"+search_txt );
			log.error("Book not found in search");
		
		}
		
		osearch.click_buynow();
		
		PFProductPage pobj = new PFProductPage(driver);
	
		pobj.click_buynow();
		
		
		PFCart cobj = new PFCart(driver);
		Assert.assertEquals(cobj.get_prod_title().toLowerCase(),exp_res);
	}
	

	@Test(dataProvider="del_cart" ,dataProviderClass=DataProviders.CartDetailsReader.class)
	public void delete_cart(String TC_ID,String order,String uname,String passwd,String search_txt,String qty, String exp_res)
	{
		Logger log = Logger.getLogger(ShoppingCart.class);
		PFLogin ologin = new PFLogin(driver);
		ologin.login(uname, passwd);
		if(driver.findElement(By.className("proper")).getText().replaceAll(" g", "").contains("qtpworld2008"))
		{
			Reporter.log("Logged in successfully");
			log.info("Logged in successfully");
		}else{
			Assert.fail("Login failed");
			log.error("Login failed");
		}
		
		
		PFSearchBook osearch = new PFSearchBook(driver);
		osearch.search(search_txt);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("find")));
		String act_res = osearch.extract_prod_string().toLowerCase();
		if(act_res.contains(search_txt))
		{
			Reporter.log("Book found on search");
			log.info("Book found on search");
		}else{
			Assert.fail("Book not found in search.Got:"+ act_res+ ",Expected:"+search_txt );
			log.error("Book not found in search");
		
		}
		
		osearch.click_buynow();
		
		PFProductPage pobj = new PFProductPage(driver);
	
		pobj.click_buynow();
		
		PFCart cobj = new PFCart(driver);
		cobj.click_delete();
		act_res = cobj.get_emtpy_cart_txt();
	
		if(act_res.equals(exp_res))
		{ 
			Reporter.log("PASS");
		}else
		{
			Reporter.log("FAILED:Got: "+ act_res +" expected: "+exp_res);
		}
		
	}


	@Test(dataProvider="update_cart" ,dataProviderClass=DataProviders.CartDetailsReader.class)
	public void update(String TC_ID,String order,String uname,String passwd,String search_txt,String qty, String exp_res) throws InterruptedException
	{
		Logger log = Logger.getLogger(ShoppingCart.class);
		PFLogin ologin = new PFLogin(driver);
		ologin.login(uname, passwd);
		if(driver.findElement(By.className("proper")).getText().replaceAll(" g", "").contains("qtpworld2008"))
		{
			Reporter.log("Logged in successfully");
			log.info("Logged in successfully");
		}else{
			Assert.fail("Login failed");
			log.error("Login failed");
		}
		
		
		PFSearchBook osearch = new PFSearchBook(driver);
		osearch.search(search_txt);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("find")));
		String act_res = osearch.extract_prod_string().toLowerCase();
		if(act_res.contains(search_txt))
		{
			Reporter.log("Book found on search");
			log.info("Book found on search");
		}else{
			Assert.fail("Book not found in search.Got:"+ act_res+ ",Expected:"+search_txt );
			log.error("Book not found in search");
		
		}
		
		osearch.click_buynow();
		
		PFProductPage pobj = new PFProductPage(driver);
	
		pobj.click_buynow();
		
		PFCart cobj = new PFCart(driver);
		
		cobj.enter_qty(String.valueOf(qty).replaceAll(".0", ""));
		Thread.sleep(4);
		
		act_res = cobj.get_net_amt();
		
	
		if(act_res.equals(exp_res))
		{ 
			Reporter.log("PASS");
		}else
		{
			Reporter.log("FAILED:Got: "+ act_res +" expected: "+exp_res);
		}
		
	}

}
