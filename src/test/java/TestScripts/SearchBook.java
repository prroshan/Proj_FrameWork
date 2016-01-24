package TestScripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import GenericClass.*;
import PageObjets.PFSearchBook;

public class SearchBook extends BaseClass {
	
	
	Logger log = Logger.getLogger(SearchBook.class);
	
	
	@Test(dataProvider="getInValidData",dataProviderClass=DataProviders.SearchBookReader.class)
	public void invalidSearch_scenario(String TCID,String order, String stext, String exp_res)
	{
		PFSearchBook obj = new PFSearchBook(driver);
		obj.search(stext);
		String act_res = obj.extract_fail_string();
		//Assert.assertEquals(exp_res, act_res);
		if(act_res.equals(exp_res))
		{
			log.info("PASS: Actual and Expected strings matched");
		}else{
			log.info("FAILED: Expected: "+exp_res +" but got: "+ act_res);
			Assert.fail("FAILED: Expected: "+exp_res +" but got: " + act_res);
		}
		
	}
	
	@Test(dataProvider="getValidData",dataProviderClass=DataProviders.SearchBookReader.class)
	public void valid_search_scenario(String TCID,String Order,String stext, String exp_res)
	{
		log.debug("Executing valid search scenario");
		PFSearchBook obj = new PFSearchBook(driver);
		obj.search(stext);
		
		String act_res = obj.extract_found_string();
		
		if(act_res.equals(exp_res.replaceAll(".0","")))
		{
			log.info("PASS");
		}
		else{
			log.info("FAILED: expected:" + exp_res +" but got actual: "+act_res);
			Assert.fail("FAILED: expected:" + exp_res +" but got actual: "+act_res);
		}
		
	}

}
