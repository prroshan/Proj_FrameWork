package PageObjets;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFCart {

	
	@FindBy(xpath="//*[@id='currentcartdiv']/div/form/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[1]/div[2]/span[2]")
	WebElement txt_title;
	
	@FindBy(xpath="//*[@id='currentcartdiv']/div/form/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[1]/div[1]/div")
	//@FindBy(xpath="//div[contains(text(),'x')]");
	//@FindBy(xpath="//*[@id='currentcartdiv']/div/form/div/table[3]/tbody/tr[3]/td/table/tbody/tr/td[1]/div[1]/div")
	WebElement btn_delete;
	
	@FindBy(xpath="//*[@id='currentcartdiv']/div[3]/form/div[1]/span")
	WebElement txt_empty_cart;
	
	@FindBy(name="quantity16933294")
	WebElement txt_qty;
	
	@FindBy(xpath="//*[@id='currentcartdiv']/div[3]/form/div/table[2]/tbody/tr[2]/td[2]/div/div[2]")
	WebElement txt_net_amt;
	
	public String get_net_amt()
	{
		return txt_net_amt.getText();
	}
	public void enter_qty(String qty)
	{
		txt_qty.clear();
		txt_qty.sendKeys(qty);
		txt_qty.sendKeys(Keys.TAB);
	}
	
	public String get_emtpy_cart_txt()
	{
		return txt_empty_cart.getText();
	}
	
	public String get_prod_title()
	{
		return txt_title.getText();
	}
	
	public void click_delete()
	{
		btn_delete.click();
	}
	
	public PFCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}


