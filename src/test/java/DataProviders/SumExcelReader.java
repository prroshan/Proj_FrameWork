package DataProviders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SumExcelReader {
	@DataProvider(name="getSumFileData")
	public static Iterator<String[]> Read() throws IOException
	{
		
		FileInputStream fis = new FileInputStream("C:/Users/rpr/Documents/TechAviator/Excel/Sum.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFCell cell;
		int rowCount = sheet.getLastRowNum();
		
		List<String []> DPList = new ArrayList<String[]>();
		
		for(int i=1;i<=rowCount;i++)
		{
			String[] arr = new String[3];
			for (int j=0;j<=2;j++)
			{
				cell = sheet.getRow(i).getCell(j);
				if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				{
					arr[j]= (String.valueOf(cell.getNumericCellValue()));
				}
			}
			DPList.add(arr);
		}
		
		return (DPList.iterator());
	}
}
