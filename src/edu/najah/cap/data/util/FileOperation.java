package edu.najah.cap.data.util;

import java.io.File;

/**
 * This class provides methods related to file manipulation.
 */

public class FileOperation {
    public static String getFileNameWithoutExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }
}
