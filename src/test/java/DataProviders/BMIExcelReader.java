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

public class BMIExcelReader {
	
	@DataProvider(name="GetTestData")
	public static Iterator<String[]> readExcel() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:/Users/rpr/Documents/TechAviator/Excel/BMI.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rows = ws.getLastRowNum();
		List<String[]> DPList = new ArrayList<String[]>();
		for(int i=1;i<=rows;i++)
		{
			String[] arr = new String[3];
			for (int j=0;j<3;j++)
			{
				XSSFCell cell = ws.getRow(i).getCell(j);
				if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				{
					arr[j] = String.valueOf(cell.getNumericCellValue());
				}
			}
			DPList.add(arr);
		}
		
		return DPList.iterator();
		
	}

}
