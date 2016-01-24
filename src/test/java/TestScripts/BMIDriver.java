package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class BMIDriver {
	
	WebDriver browser;
	
	@BeforeMethod
	public void Initialize()
	{
		try{
			WindowsUtils.killByName("firefox.exe");
		}catch(Exception e)
		{}
		browser = new FirefoxDriver();
		browser.manage().deleteAllCookies();
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		browser.get("http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmi-m.htm");
	}
	
	
	@Test(dataProvider="GetTestData",dataProviderClass=DataProviders.BMIExcelReader.class)
	public void CalcBMI(String ht, String wt, String exp_bmi)
	{
		
		browser.findElement(By.name("htc")).clear();;
		browser.findElement(By.name("htc")).sendKeys(ht);
		browser.findElement(By.name("kg")).clear();
		browser.findElement(By.name("kg")).sendKeys(wt);
		browser.findElement(By.cssSelector("input[type='button'][value='Compute BMI']")).click();
		String act_bmi = browser.findElement(By.name("bmi")).getAttribute("value");
		Assert.assertEquals(exp_bmi, act_bmi);
		
	}

	@AfterMethod
	public void close()
	{
		browser.close();
	}
	
	@Test(enabled=false)
	//public void CalcBMI(String ht, String wt, String exp_bmi)
	public void CalcBMI1()
	{
		
		browser.findElement(By.name("htc")).clear();;
		browser.findElement(By.name("htc")).sendKeys("168");
		browser.findElement(By.name("kg")).clear();
		browser.findElement(By.name("kg")).sendKeys("70");
		browser.findElement(By.cssSelector("input[type='button'][value='Compute BMI']")).click();
		String act_bmi = browser.findElement(By.name("bmi")).getAttribute("value");
		System.out.println(act_bmi);
		
	}
}
