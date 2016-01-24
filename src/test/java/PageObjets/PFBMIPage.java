package PageObjets;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFBMIPage {
	
	@FindBy(css="a[href='bmi-m.html]")
	WebElement metricTab;
	
	@FindBy(css="img[src='images/bmi-e_01.gif']")
	WebElement stdTab;
	
	@FindBy(name="htc")
	WebElement height;
	
	@FindBy(name="kg")
	WebElement weight;
	
	@FindBy(xpath="//input[@value='Compute BMI']")
	WebElement computeBtn;
	
	@FindBy(name="bmi")
	WebElement bmi;
	
	
	public void switchToMetricTab()
	{
		metricTab.click();
	}
	
	public void swithToStandardTab()
	{
		stdTab.click();
	}
	
	public void enterHeight(String ht)
	{
		height.sendKeys(ht);
	}
	
	public void enterWeight(String wt)
	{
		weight.sendKeys(wt);
	}
	
	public void clickComputeBtn()
	{
		computeBtn.click();
	}
	
	public String getBmi()
	{
		return bmi.getAttribute("value");
	}
	
	public PFBMIPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
}
	
