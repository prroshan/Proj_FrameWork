package GenericClass;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	protected WebDriver driver;
	
	@BeforeMethod
	protected void intialize() throws IOException
	{
		/*try{
			WindowsUtils.killByName("firefox.exe");
		}catch(Exception e)
		{
			
		}*/
	
		driver = new FirefoxDriver();
		driver.get(Utility.getValue("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	protected void tearDown()
	{
		driver.quit();
	}
}
