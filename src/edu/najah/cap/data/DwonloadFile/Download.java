package edu.najah.cap.data.DwonloadFile;

import edu.najah.cap.exceptions.SystemBusyException;
import org.apache.log4j.Logger;

import java.io.*;

public class Download {
    public Logger logger =Logger.getLogger(Download.class);
    public void downloadFile(File fileContent, String fileName) throws Exception {
        try (InputStream inputStream = new FileInputStream(fileContent);
             OutputStream outputStream = new FileOutputStream(fileName)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            logger.info("Download file successfully");
        }
        catch (RuntimeException err){
            logger.error("System Busy : "+err.getMessage());
            throw new SystemBusyException("Server is busy");
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }
    }
}
