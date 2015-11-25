package de.sms.tabletennis.excel.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import de.sms.tabletennis.entities.Adress;
import de.sms.tabletennis.entities.Email;
import de.sms.tabletennis.entities.EmailType;
import de.sms.tabletennis.entities.PhoneNumber;
import de.sms.tabletennis.entities.PhoneType;
import de.sms.tabletennis.entities.Player;
import de.sms.tabletennis.excel.ExcelImporter;
import de.sms.tabletennis.services.AdressService;
import de.sms.tabletennis.services.EmailService;
import de.sms.tabletennis.services.PhoneNumberService;
import de.sms.tabletennis.services.PlayerService;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

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
	public ExcelImporterImpl(PhoneNumberService phoneNumberService, EmailService emailService, AdressService adressService,
			PlayerService playerService) {
		super();
		this.phoneNumberService = phoneNumberService;
		this.emailService = emailService;
		this.adressService = adressService;
		this.playerService = playerService;
	}

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
		catch (BiffException be) {
			be.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public Player importPlayer(Sheet sheet, int rowNumber) {
		Player player = new Player();
		String lastName = sheet.getCell(ROW_LAST_NAME, rowNumber).getContents();
		String firstName = sheet.getCell(ROW_FIRST_NAME, rowNumber).getContents();
		if(((StringUtils.isEmpty(lastName) && StringUtils.isEmpty(firstName))) 
				|| (playerService.findByFirstNameAndLastName(firstName, lastName).iterator().hasNext())) {
			return null;
		}
		player.setLastName(lastName);
		player.setFirstName(firstName);
		String privatePhoneNumber = sheet.getCell(ROW_PRIVATE_PHONE, rowNumber).getContents();
		PhoneNumber privatePhone = new PhoneNumber(PhoneType.PRIVATE, privatePhoneNumber);
		if(phoneNumberService.validate(privatePhone)) {
			phoneNumberService.save(privatePhone);
			player.setPrivatePhone(privatePhone);
		}
		String mobilePhoneNumber = sheet.getCell(ROW_MOBILE_PHONE, rowNumber).getContents();
		PhoneNumber mobilePhone = new PhoneNumber(PhoneType.MOBILE, mobilePhoneNumber);
		if(phoneNumberService.validate(mobilePhone)) {
			phoneNumberService.save(mobilePhone);
			player.setMobilePhone(mobilePhone);
		}
		String businessPhoneNumber= sheet.getCell(ROW_BUSINESS_PHONE, rowNumber).getContents();
		PhoneNumber businessPhone = new PhoneNumber(PhoneType.BUSINESS, businessPhoneNumber);
		if(phoneNumberService.validate(businessPhone)) {
			phoneNumberService.save(businessPhone);
			player.setBusinessPhone(businessPhone);
		}
		String privateEmailAdress = sheet.getCell(ROW_PRIVATE_EMAIL, rowNumber).getContents();
		Email privateEmail = new Email(EmailType.PRIVATE, privateEmailAdress);
		if(emailService.validate(privateEmail)) {
			emailService.save(privateEmail);
			player.setPrivateEmail(privateEmail);
		}
		String businessEmailAdress = sheet.getCell(ROW_BUSINESS_EMAIL, rowNumber).getContents();
		Email businessEmail = new Email(EmailType.BUSINESS, businessEmailAdress);
		if(emailService.validate(businessEmail)) {
			emailService.save(businessEmail);
			player.setBusinessEmail(businessEmail);
		}
		
		String street = sheet.getCell(ROW_STREET, rowNumber).getContents();
		String city = sheet.getCell(ROW_CITY, rowNumber).getContents();
		String postalCodeString = sheet.getCell(ROW_POSTAL_CODE, rowNumber).getContents();
		int postalCode = Integer.parseInt(postalCodeString);
		Adress adress = new Adress(street, postalCode, city);
		adressService.save(adress);
		player.setAdress(adress);
		
		Date birthday = (Date) ((DateCell) sheet.getCell(ROW_BIRTHDAY, rowNumber)).getDate();
		player.setBirthday(birthday);
		
//		Player player = new Player(adress, firstName, lastName, privatePhone, mobilePhone, businessPhone, privateEmail, businessEmail, birthday);
		playerService.save(player);
		
		return player;
	}

}
