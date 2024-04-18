package com.selenium.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexcel_own {
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileout = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public readexcel_own(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public String getcelldata(String sheetname, int colname, int rowname) {
		try {
			if (rowname <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetname);
			if (index == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowname-1);
			if (row == null)
				return "";
			cell = row.getCell(colname);
			if (cell == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String celltext = String.valueOf(cell.getNumericCellValue());
				return celltext;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());

			}

		} catch (Exception e) {
			e.printStackTrace();
			return "row" + rowname + " or cloumn" + colname + "does not exist";
		}
	}

}
