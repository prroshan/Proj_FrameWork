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
	
public class CartDetailsReader {

		
		public static List<String []> getData(String scriptName) throws IOException
		{
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Test_Data.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Cart");
			
			int rowCount = sheet.getLastRowNum();
			List<String[]> clist = new ArrayList<String[]>();
			for(int i=1;i<=rowCount; i++)
			{
				
				if(sheet.getRow(i).getCell(3).getStringCellValue().equals(scriptName) &&  sheet.getRow(i).getCell(2).getStringCellValue().equals("Y"))
				{
					String[] arr = new String[7];
					
					arr[0] = sheet.getRow(i).getCell(0).getStringCellValue();
					arr[1] = Double.toString(sheet.getRow(i).getCell(1).getNumericCellValue());
					arr[2] = sheet.getRow(i).getCell(4).getStringCellValue();
					arr[3] = sheet.getRow(i).getCell(5).getStringCellValue();
					arr[4] = sheet.getRow(i).getCell(6).getStringCellValue();
					arr[5] = Double.toString(sheet.getRow(i).getCell(7).getNumericCellValue());
					XSSFCell cell = sheet.getRow(i).getCell(8);
					if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
					{
						arr[6] = String.valueOf(cell.getNumericCellValue());
					}else
					{
						arr[6] = sheet.getRow(i).getCell(8).getStringCellValue();
					}	
					clist.add(arr);
				}
			}
			
			fis.close();
			return clist;
			
		}

		@DataProvider(name="add_cart")
		public static Iterator<String[]> addToCart() throws IOException
		{
			return getData("Add_Cart").iterator();
		}
		
		@DataProvider(name="del_cart")
		public static Iterator<String[]> del_cart() throws IOException
		{
			return getData("Delete_Cart").iterator();
		}
		
		@DataProvider(name="update_cart")
		public static Iterator<String[]> update_cart() throws IOException
		{
			return getData("Update_Cart").iterator();
		}
		
}

