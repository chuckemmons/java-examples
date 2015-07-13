package com.cee.example.poi.spreadsheet;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cee.example.poi.constants.Border;
import com.cee.example.poi.domain.Table;

public abstract class SpreadSheetGenerator {
	private static final int BEGIN_ROW_INDEX = 1;
	private static final int BEGIN_CELL_INDEX = 1;

	public static void generateTableSpreadsheet(String filename,
			String tabTitle, String sheetHeading, List<Table> tables) {
		// Blank workbook
		Workbook workbook = new XSSFWorkbook();
		// Create a blank sheet
		Sheet sheet = workbook.createSheet(tabTitle);
		// Create the sheet header
		createSheetHeader(workbook, sheet, BEGIN_ROW_INDEX, sheetHeading);
		// CellUtil.
		// TODO: STOPPED HERE.
		// populateWorkbookWithJunkData(workbook);
		if (saveSpreadSheet(workbook, filename)) {
			System.out.println(filename + " written successfully on disk.");
		} else {
			System.out.println("Unable to generate " + filename);
		}
	}

	private static void createSheetHeader(Workbook workbook, Sheet sheet,
			int rowIndex, String sheetHeading) {
		Row row = sheet.createRow(rowIndex);
		Cell cell = row.createCell(BEGIN_CELL_INDEX);
		cell.setCellValue(sheetHeading);
	}

	private static CellStyle sheetHeadingCellStyle(Workbook wb) {
		CellStyle cs = wb.createCellStyle();
		cs.setAlignment(CellStyle.ALIGN_CENTER);
		short borderStyle = CellStyle.BORDER_THIN;
		cs.setBorderLeft(borderStyle);
		cs.setBorderBottom(borderStyle);
		cs.setBorderRight(borderStyle);
		cs.setBorderTop(borderStyle);
		addSheetHeadingBorder(cs);
		// TODO: Start Here....
		return cs;
	}

	private static void addSheetHeadingBorder(CellStyle cs) {
		cs.setBottomBorderColor(Border.Color.SHEET_HEADING);
		cs.setTopBorderColor(Border.Color.SHEET_HEADING);
		cs.setLeftBorderColor(Border.Color.SHEET_HEADING);
		cs.setRightBorderColor(Border.Color.SHEET_HEADING);
		cs.setLeftBorderColor(Border.Color.SHEET_HEADING);
	}

	private static boolean saveSpreadSheet(Workbook workbook, String filename) {
		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(filename));
			workbook.write(out);
			out.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
