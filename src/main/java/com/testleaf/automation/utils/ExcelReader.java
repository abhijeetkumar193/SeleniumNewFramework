package com.testleaf.automation.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.testleaf.automation.ProjectSpecificMethods.ProjectSpecificMethods;

public class ExcelReader extends ProjectSpecificMethods {

	
	public static  String[][] getExcelData(String filePath, int sheetNumber) throws IOException
	{
		XSSFWorkbook wb = new XSSFWorkbook(filePath);
		XSSFSheet sh= wb.getSheetAt(sheetNumber);
		int rowCount=sh.getRow(1).getLastCellNum();
		int colCount=sh.getRow(1).getLastCellNum();
 		String[][] dataProvider= new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				dataProvider[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			//	System.out.println("heoow testing te git hubs");
			}
		}
		wb.close();
		return dataProvider;
		
	}
}
