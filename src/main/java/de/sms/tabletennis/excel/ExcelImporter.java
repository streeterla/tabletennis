package de.sms.tabletennis.excel;

import de.sms.tabletennis.entities.Player;
import jxl.Sheet;
import org.springframework.beans.factory.annotation.Value;

public interface ExcelImporter {

	String SYNC_FILE = "resources/Kontaktliste.xls";

	/**
	 * provides a full import of the contact excel into database
	 */
	public void fullImport();

	/**
	 * imports one player into database
	 *
	 * @param sheet in the excel
	 * @param rowNumber of the player
	 * @return the player to import
	 */
	public Player importPlayer(Sheet sheet, int rowNumber);
}
