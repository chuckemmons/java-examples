package com.cee.example.poi.domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private String header;

	private List<TblRow> tblRows = new ArrayList<TblRow>();

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * @return the tblRows
	 */
	public List<TblRow> getTblRows() {
		return tblRows;
	}

	/**
	 * @param tblRows
	 *            the tblRows to set
	 */
	public void setTblRows(List<TblRow> tblRows) {
		this.tblRows = tblRows;
	}

	public static enum COLUMN_NAME {
		COLUMN_1, COLUMN_2, COLUMN_3;

		public List<String> columnNames() {
			List<String> columnNames = new ArrayList<String>();
			for (COLUMN_NAME columnName : values()) {
				columnNames.add(columnName.name());
			}
			return columnNames;
		}
	}
}
