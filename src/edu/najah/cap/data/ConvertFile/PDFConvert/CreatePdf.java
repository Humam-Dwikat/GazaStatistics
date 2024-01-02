package edu.najah.cap.data.ConvertFile.PDFConvert;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import edu.najah.cap.data.collectData.CollectFactory;

import java.io.File;
import java.io.IOException;

public class CreatePdf {

    public File create_pdf(String user_id, Object service){
        CollectFactory collectFactory = new CollectFactory();
        Object data = collectFactory.get_data(service,user_id);
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();

            document.add(new Paragraph(data.toString())); // Replace with appropriate content formatting


            document.close();

            // Convert ByteArrayOutputStream content to byte array
            byte[] pdfBytes = byteArrayOutputStream.toByteArray();

            // Create a File object from the byte array
            File generatedFile = File.createTempFile("generated_file", ".pdf");
            java.nio.file.Files.write(generatedFile.toPath(), pdfBytes);

            return generatedFile;
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
