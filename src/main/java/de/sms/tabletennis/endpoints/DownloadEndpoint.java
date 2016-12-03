package de.sms.tabletennis.endpoints;

import de.sms.tabletennis.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class DownloadEndpoint {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletResponse response) {
        fileService.downloadSyncFile(response);
    }
}
