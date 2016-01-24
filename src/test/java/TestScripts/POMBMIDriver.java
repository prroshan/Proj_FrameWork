package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjets.PFBMIPage;


public class POMBMIDriver {

WebDriver browser;
	
@BeforeMethod
public void InitializeBrowser()
	{
	try{
		WindowsUtils.killByName("firefox.exe");
	}catch(Exception e)
	{
		
	}
	browser = new FirefoxDriver();
	
	browser.manage().deleteAllCookies();
	//browser.get("http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm");
	browser.get("http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmi-m.htm");
	browser.manage().window().maximize();
	browser.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
}

@Test(dataProvider="GetTestData",dataProviderClass=DataProviders.BMIExcelReader.class)
public void computeBMI(String ht,String wt,String expBmi)
{
	
	PFBMIPage obj = new PFBMIPage(browser);
	//obj.switchToMetricTab();
	obj.enterHeight(ht);
	obj.enterWeight(wt);
	obj.clickComputeBtn();
	
	Assert.assertEquals(expBmi,obj.getBmi());
}

@AfterMethod
public void close()
{
	browser.close();
}

}
