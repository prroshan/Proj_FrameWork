package TestScripts;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;
import DataProviders.SumExcelReader;
public class SumDriver {
	
	
	@Test(dataProvider="getSumFileData",dataProviderClass=DataProviders.SumExcelReader.class)
	public void sum(String n1, String n2 ,String exp_res)
	
	{
		Logger log = Logger.getLogger(SumDriver.class);
		
		Double actualSum = Double.parseDouble(n1) + Double.parseDouble(n2);
		System.out.println("Actual sum: "+ actualSum);
		Double expected = Double.parseDouble(exp_res);
		System.out.println("Expected: "+expected);
		//Assert.assertEquals(expected,actualSum);
		
		if(expected == actualSum)
		{
			log.info("PASS");
		}
		else{
			Assert.fail("Actual sum does not match expected");
			log.info("Actual sum does not match expected");
		}
	}
}

