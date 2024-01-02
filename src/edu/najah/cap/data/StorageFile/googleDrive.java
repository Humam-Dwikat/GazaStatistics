package edu.najah.cap.data.StorageFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class googleDrive implements IUpload{
    private final Map<String, File> files =new HashMap<>();

    public File get_file(String file_name){
       return files.get(file_name);
    }

    @Override
    public void upload(String file_name, File file) {
        files.put(file_name,file);

    }
}
