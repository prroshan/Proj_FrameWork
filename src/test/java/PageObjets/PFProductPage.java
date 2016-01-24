package PageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFProductPage {

	@FindBy(className="detailed-description-head")
	WebElement txt_book_title;
	
	@FindBy(className="addtocartbtn")
	WebElement btn_buynow;
	
	 public String extract_book_title()
	{
		return txt_book_title.getText();
	}
	
	 public void click_buynow()
	 {
		 btn_buynow.click();
	 }
	 
	public PFProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
