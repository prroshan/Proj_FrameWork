package DataProviders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginCredentialsReader {

	public static List<String[]> getLoginData(String scenario) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\Test_Data.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sh = wb.getSheetAt(0);
		
		List<String[]> llist = new ArrayList<String[]>();
		
		for( int i=1; i<=sh.getLastRowNum();i++)
		{
			if(sh.getRow(i).getCell(3).getStringCellValue().equals(scenario) && sh.getRow(i).getCell(2).getStringCellValue().equals("Y"))
			{
				String arr[] = new String[5];
				arr[0] = sh.getRow(i).getCell(0).getStringCellValue();
				arr[1] = Double.toString(sh.getRow(i).getCell(1).getNumericCellValue());
				arr[2] = sh.getRow(i).getCell(4).getStringCellValue();
				arr[3] = sh.getRow(i).getCell(5).getStringCellValue();
				arr[4] = sh.getRow(i).getCell(6).getStringCellValue();
				llist.add(arr);		
			}
		}
		
		return llist;
	}

	@DataProvider(name="validlogin")
	public static Iterator<String[]> valid_login() throws IOException
	{
		return getLoginData("Valid_Login").iterator();
	}
	
	@DataProvider(name="invalidlogin")
	public static Iterator<String[]> invalid_login() throws IOException
	{
		return getLoginData("Invalid_Login").iterator();
	}
}

