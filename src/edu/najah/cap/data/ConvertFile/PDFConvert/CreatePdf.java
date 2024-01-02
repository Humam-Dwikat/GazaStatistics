package edu.najah.cap.data.ConvertFile.PDFConvert;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import edu.najah.cap.data.collectData.CollectFactory;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class CreatePdf {
    private final Logger logger = Logger.getLogger(CreatePdf.class);
    public File create_pdf(String user_id, Object service) throws Exception {
        CollectFactory collectFactory = new CollectFactory();
        Object data = collectFactory.get_data(service, user_id);
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            document.add(new Paragraph(data.toString()));

            document.close();
            byte[] pdfBytes = byteArrayOutputStream.toByteArray();
            File generatedFile = File.createTempFile("generated_file", ".pdf");
            java.nio.file.Files.write(generatedFile.toPath(), pdfBytes);
            logger.info("Create PDF file successfully");
            return generatedFile;

        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        } catch (Exception err) {
            logger.error("Error: " + err.getMessage());
            throw new Exception();
        }

    }
}
