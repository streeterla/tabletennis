package de.sms.tabletennis.services;

import javax.servlet.http.HttpServletResponse;

public interface FileService {

    void downloadSyncFile(HttpServletResponse httpServletResponse);
}
