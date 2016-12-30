package de.sms.tabletennis.endpoints;

import de.sms.tabletennis.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@CrossOrigin(origins="*")
@RestController
public class UploadEndpoint {

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value="/fileUpload", method = RequestMethod.POST)
    public void UploadFile(MultipartHttpServletRequest request) throws IOException {

        uploadService.uploadFile(request);

    }
}