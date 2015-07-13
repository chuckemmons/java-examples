package com.cee.example.poi;

import java.util.ArrayList;
import java.util.List;

import com.cee.example.poi.domain.TblRow;
import com.cee.example.poi.domain.Table;
import com.cee.example.poi.spreadsheet.SpreadSheetGenerator;

/**
 * Hello world!
 *
 */
public class App {
	private static final String FILENAME = "work_poc.xlsx";
	private static final String TAB_TITLE = "The results";
	private static final String HEADING = "A Spreadsheet of tables";

	public static void main(String[] args) {
		List<Table> tables = generateTables();

		SpreadSheetGenerator.generateTableSpreadsheet(FILENAME, TAB_TITLE,
				HEADING, tables);
	}

	private static List<Table> generateTables() {
		List<Table> tables = new ArrayList<Table>();
		// create 5 tables
		for (int i = 1; i < 5; i++) {
			Table table = new Table();
			table.setHeader("Table " + i);
			// generate 4 records in each table
			for (int j = 1; j < 4; j++) {
				TblRow tblRow = new TblRow();
				tblRow.setColumn1("T" + i + "R" + j + "C" + 1);
				tblRow.setColumn2("T" + i + "R" + j + "C" + 2);
				tblRow.setColumn3("T" + i + "R" + j + "C" + 3);
				table.getTblRows().add(tblRow);
			}
			tables.add(table);
		}
		return tables;
	}
}
