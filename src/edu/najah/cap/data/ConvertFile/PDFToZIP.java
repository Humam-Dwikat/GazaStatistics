package edu.najah.cap.data.ConvertFile;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PDFToZIP implements IconvertTo {
    Logger logger = Logger.getLogger(PDFToZIP.class);

    @Override
    public File createZipFile(File fileToZip) throws IOException {
        File zipFile = File.createTempFile("generated_zip", ".zip");

        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            ZipEntry entry = new ZipEntry(fileToZip.getName());
            zos.putNextEntry(entry);

            try (FileInputStream fis = new FileInputStream(fileToZip)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    zos.write(buffer, 0, bytesRead);
                }
            }
            catch (Exception err){
                logger.error("Error while create zip file: "+ err);
            }

            zos.closeEntry();
            logger.info("Convert the file to Zip file ");

        }
        catch (FileNotFoundException err){
            logger.error("Error: File not found"+err.toString());
            throw new FileNotFoundException("File not found");
        }
        catch (Exception err){
            logger.error("Error while create zip file: " + err);
        }

        return zipFile;
    }
}
