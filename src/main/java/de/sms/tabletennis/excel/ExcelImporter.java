package de.sms.tabletennis.excel;

import de.sms.tabletennis.entities.Player;
import jxl.Sheet;

public interface ExcelImporter {
	
	int ROW_LAST_NAME = 0;
	int ROW_FIRST_NAME = 1;
	int ROW_PRIVATE_PHONE = 2;
	int ROW_MOBILE_PHONE = 3;
	int ROW_BUSINESS_PHONE = 4;
	int ROW_PRIVATE_EMAIL = 5;
	int ROW_BUSINESS_EMAIL = 6;
	int ROW_STREET = 7;
	int ROW_POSTAL_CODE = 8;
	int ROW_CITY = 9;
	int ROW_BIRTHDAY = 10;
	
	String SYNC_FILE = "resources/Kontaktliste.xls";
	
	
	public void fullImport();
	public Player importPlayer(Sheet sheet, int rowNumber);
}
