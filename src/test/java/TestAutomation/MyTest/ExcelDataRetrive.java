package TestAutomation.MyTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataRetrive {
	
	
	@Test
	public void getData() throws IOException
	{
		File file=new File("C:\\Users\\vignesh\\Documents\\AutomationData.xlsx");
		FileInputStream is=new FileInputStream(file); 
		XSSFWorkbook wb=new XSSFWorkbook(is);
		XSSFSheet sheet=wb.getSheetAt(0);
		XSSFRow row=sheet.getRow(1);
		XSSFCell cell=row.getCell(0);
		String username=cell.getStringCellValue();
		System.out.println(username);
		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=0;i<=rowcount;i++)
		{
			int cellcount=sheet.getRow(i).getLastCellNum();
			for(int j=0;j<cellcount;j++)
			{
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+",");
			}
			System.out.println();
		}
	
	
	}
	

}
