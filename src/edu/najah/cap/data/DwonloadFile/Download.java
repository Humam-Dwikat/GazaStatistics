package edu.najah.cap.data.DwonloadFile;

import java.io.*;

public class Download {
    public void downloadFile(File fileContent, String fileName) throws IOException {
        try (InputStream inputStream = new FileInputStream(fileContent);
             OutputStream outputStream = new FileOutputStream(fileName)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
