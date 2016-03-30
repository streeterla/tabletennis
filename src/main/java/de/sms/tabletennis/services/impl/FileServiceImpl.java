package de.sms.tabletennis.services.impl;

import de.sms.tabletennis.services.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class FileServiceImpl implements FileService {

    @Value("${sync.file}")
    private String SYNC_FILE;

    @Override
    public void downloadSyncFile(HttpServletResponse httpServletResponse) {
        try {
            File syncFile = new File(SYNC_FILE);
            InputStream is = new FileInputStream(syncFile);
            httpServletResponse.setContentType("application/xls");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + syncFile.getName());
            IOUtils.copy(is, httpServletResponse.getOutputStream());
            httpServletResponse.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
