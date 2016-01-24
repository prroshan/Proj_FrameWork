package PageObjets;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class PFSearchBook {
	
	
	@FindBy(id="srchword")
	WebElement txt_search;
	
	@FindBy(className="newsrchbtn")
	WebElement btn_search;
	
	@FindBy(className="sorrymsg")
	WebElement txt_fail_msg;
	
	@FindBy(id="find")
	WebElement txt_found_msg;
	
	@FindBy(css="a[title='Who Moved My Cheese: Book by Spencer Johnson']")
	WebElement txt_prod;
	
	@FindBy(xpath="//*[@id='myDataDiv']/div/div[1]/div[5]/a/div")
	WebElement btn_buynow;
	
	public void click_buynow()
	{
		btn_buynow.click();
	}
	
	public String extract_prod_string()
	{
		
		return txt_prod.getAttribute("title");
	}
			
	
	public void enter_search(String stxt)
	{
		txt_search.sendKeys(stxt);
	}
	
	public void click_search()
	{
		btn_search.click();
	}
	
	public String extract_found_string()
	{
		return txt_found_msg.getText();
	}
	
	public String extract_fail_string()
	{
		return txt_fail_msg.getText();
	}
	
	public void search(String stxt)
	{
		enter_search(stxt);
		click_search();
	}
	
	public PFSearchBook(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
