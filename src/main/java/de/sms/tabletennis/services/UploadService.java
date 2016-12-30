package de.sms.tabletennis.services;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

public interface UploadService {

	boolean uploadFile(MultipartHttpServletRequest request) throws IOException;
}
