package de.sms.tabletennis.services.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import de.sms.tabletennis.services.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class UploadServiceImpl implements UploadService {

	@Value("${sync.file}")
	private String SYNC_FILE;

	@Override
	public boolean uploadFile(MultipartHttpServletRequest request) throws IOException {
		Iterator<String> itr=request.getFileNames();
		MultipartFile file=request.getFile(itr.next());
		File serverFile = new File(SYNC_FILE);
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));
		stream.write(file.getBytes());
		stream.close();
		return true;
	}

}
