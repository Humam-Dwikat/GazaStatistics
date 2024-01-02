package edu.najah.cap.data.ConvertFile;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PDFToZIP implements IconvertTo {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Override
    public File createZipFile(File fileToZip) throws IOException {
        File zipFile = File.createTempFile("generated_zip", ".zip");

        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            // Add the file to ZIP
            ZipEntry entry = new ZipEntry(fileToZip.getName()); // Use the original file name in ZIP
            zos.putNextEntry(entry);

            // Write file content to ZIP
            try (FileInputStream fis = new FileInputStream(fileToZip)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    zos.write(buffer, 0, bytesRead);
                }
            }

            zos.closeEntry();
        }

        return zipFile;
    }}
