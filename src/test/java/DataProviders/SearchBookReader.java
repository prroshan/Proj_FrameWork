package DataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SearchBookReader {
	
	public static List<String []> getData(String scriptName) throws IOException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Test_Data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Search");
		
		int rowCount = sheet.getLastRowNum();
		List<String[]> slist = new ArrayList<String[]>();
		for(int i=1;i<=rowCount; i++)
		{
			
			if(sheet.getRow(i).getCell(3).getStringCellValue().equals(scriptName) &&  sheet.getRow(i).getCell(2).getStringCellValue().equals("Y"))
			{
				XSSFCell cell;
				String[] arr = new String[4];
				arr[0] = sheet.getRow(i).getCell(0).getStringCellValue();
				
				arr[1] = Double.toString(sheet.getRow(i).getCell(1).getNumericCellValue());
				arr[2] = sheet.getRow(i).getCell(4).getStringCellValue();
				cell = sheet.getRow(i).getCell(5);
				if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				{
					arr[3] = Double.toString(cell.getNumericCellValue());
				}else{
					arr[3] = cell.getStringCellValue();
				}
				slist.add(arr);
			}
		}
		
		fis.close();
		return slist;
		
	}

	@DataProvider(name="getValidData")
	public static Iterator<String[]> validSearch() throws IOException
	{
		return getData("Valid_Search").iterator();
	}
	
	@DataProvider(name="getInValidData")
	public static Iterator<String[]> invalidSearch() throws IOException
	{
		return getData("Invalid_Search").iterator();
	}
	
}
