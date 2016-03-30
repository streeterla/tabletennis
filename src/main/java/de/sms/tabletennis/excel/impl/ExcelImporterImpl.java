package de.sms.tabletennis.excel.impl;

import de.sms.tabletennis.entities.*;
import de.sms.tabletennis.excel.ExcelImporter;
import de.sms.tabletennis.services.*;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Component
public class ExcelImporterImpl implements ExcelImporter {
	
	@Autowired
	private PhoneNumberService phoneNumberService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private AdressService adressService;
	
	@Autowired
	private PlayerService playerService;

	@Autowired
	private AccountService accountService;

	@Value("${COLUMN.LAST.NAME}")
	private int COLUMN_LAST_NAME;
	@Value("${COLUMN.FIRST.NAME}")
	private int COLUMN_FIRST_NAME;
	@Value("${COLUMN.PRIVATE.PHONE}")
	private int COLUMN_PRIVATE_PHONE;
	@Value("${COLUMN.MOBILE.PHONE}")
	private int COLUMN_MOBILE_PHONE;
	@Value("${COLUMN.BUSINESS.PHONE}")
	private int COLUMN_BUSINESS_PHONE;
	@Value("${COLUMN.PRIVATE.EMAIL}")
	private int COLUMN_PRIVATE_EMAIL;
	@Value("${COLUMN.BUSINESS.EMAIL}")
	private int COLUMN_BUSINESS_EMAIL;
	@Value("${COLUMN.STREET}")
	private int COLUMN_STREET;
	@Value("${COLUMN.POSTAL.CODE}")
	private int COLUMN_POSTAL_CODE;
	@Value("${COLUMN.CITY}")
	private int COLUMN_CITY;
	@Value("${COLUMN.BIRTHDAY}")
	private int COLUMN_BIRTHDAY;
	@Value("${sync.file}")
	private String SYNC_FILE;

	@Override
	public void fullImport()  {
		File syncFile = new File(SYNC_FILE) ;
		Workbook wb;
		WorkbookSettings ws = new WorkbookSettings();
		ws.setEncoding("cp1252");  
		try {
			wb = Workbook.getWorkbook(syncFile, ws);
			Sheet sheet = wb.getSheet(0);
			for(int row = 1; row < sheet.getRows(); row++) {
				importPlayer(sheet, row);
			}
		}
		catch (BiffException | IOException be) {
			be.printStackTrace();
		}
	}

	@Override
	public Player importPlayer(Sheet sheet, int rowNumber) {
		Player player = new Player();
		String lastName = sheet.getCell(COLUMN_LAST_NAME, rowNumber).getContents();
		String firstName = sheet.getCell(COLUMN_FIRST_NAME, rowNumber).getContents();
		if(((StringUtils.isEmpty(lastName) && StringUtils.isEmpty(firstName))) 
				|| (playerService.findByFirstNameAndLastName(firstName, lastName).iterator().hasNext())) {
			accountService.save(player);
			return null;
		}
		player.setLastName(lastName);
		player.setFirstName(firstName);
		String privatePhoneNumber = sheet.getCell(COLUMN_PRIVATE_PHONE, rowNumber).getContents();
		PhoneNumber privatePhone = new PhoneNumber(PhoneType.PRIVATE, privatePhoneNumber);
		if(phoneNumberService.validate(privatePhone)) {
			phoneNumberService.save(privatePhone);
			player.setPrivatePhone(privatePhone);
		}
		String mobilePhoneNumber = sheet.getCell(COLUMN_MOBILE_PHONE, rowNumber).getContents();
		PhoneNumber mobilePhone = new PhoneNumber(PhoneType.MOBILE, mobilePhoneNumber);
		if(phoneNumberService.validate(mobilePhone)) {
			phoneNumberService.save(mobilePhone);
			player.setMobilePhone(mobilePhone);
		}
		String businessPhoneNumber= sheet.getCell(COLUMN_BUSINESS_PHONE, rowNumber).getContents();
		PhoneNumber businessPhone = new PhoneNumber(PhoneType.BUSINESS, businessPhoneNumber);
		if(phoneNumberService.validate(businessPhone)) {
			phoneNumberService.save(businessPhone);
			player.setBusinessPhone(businessPhone);
		}
		String privateEmailAdress = sheet.getCell(COLUMN_PRIVATE_EMAIL, rowNumber).getContents();
		Email privateEmail = new Email(EmailType.PRIVATE, privateEmailAdress);
		if(emailService.validate(privateEmail)) {
			emailService.save(privateEmail);
			player.setPrivateEmail(privateEmail);
		}
		String businessEmailAdress = sheet.getCell(COLUMN_BUSINESS_EMAIL, rowNumber).getContents();
		Email businessEmail = new Email(EmailType.BUSINESS, businessEmailAdress);
		if(emailService.validate(businessEmail)) {
			emailService.save(businessEmail);
			player.setBusinessEmail(businessEmail);
		}
		
		String street = sheet.getCell(COLUMN_STREET, rowNumber).getContents();
		String city = sheet.getCell(COLUMN_CITY, rowNumber).getContents();
		String postalCodeString = sheet.getCell(COLUMN_POSTAL_CODE, rowNumber).getContents();
		int postalCode = Integer.parseInt(postalCodeString);
		Adress adress = new Adress(street, postalCode, city);
		adressService.save(adress);
		player.setAdress(adress);
		
		Date birthday = ((DateCell) sheet.getCell(COLUMN_BIRTHDAY, rowNumber)).getDate();
		player.setBirthday(birthday);
		
		playerService.save(player);
		accountService.save(player);
		
		return player;
	}

}
