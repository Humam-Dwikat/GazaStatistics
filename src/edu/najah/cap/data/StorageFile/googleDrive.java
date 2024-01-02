package edu.najah.cap.data.StorageFile;

import edu.najah.cap.exceptions.SystemBusyException;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class googleDrive implements IUpload{
    private Logger logger =Logger.getLogger(googleDrive.class);
    private final Map<String, File> files =new HashMap<>();

    public File get_file(String file_name){
       return files.get(file_name);
    }

    @Override
    public void upload(String file_name, File file) throws Exception {
        try {
            files.put(file_name, file);
            logger.info("Upload data to google drive successfully");
        }catch (RuntimeException err){
            logger.error("System Busy : "+err.getMessage());
            throw new SystemBusyException("Server is busy");
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }
    }
}
