package de.sms.tabletennis.excel;

import de.sms.tabletennis.entities.Player;
import jxl.Sheet;

public interface ExcelImporter {

	/**
	 * provides a full import of the contact excel into database
	 */
	void fullImport();

	/**
	 * imports one player into database
	 *
	 * @param sheet in the excel
	 * @param rowNumber of the player
	 * @return the player to import
	 */
	Player importPlayer(Sheet sheet, int rowNumber);
}
