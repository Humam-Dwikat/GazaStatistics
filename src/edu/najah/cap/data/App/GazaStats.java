package edu.najah.cap.data.App;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.data.AddData.Addfactory;
import edu.najah.cap.data.ConvertFile.PDFConvert.CreatePdf;
import edu.najah.cap.data.ConvertFile.PDFToZIP;
import edu.najah.cap.data.DwonloadFile.Download;
import edu.najah.cap.data.StorageFile.IUpload;
import edu.najah.cap.data.StorageFile.googleDrive;
import edu.najah.cap.data.collectData.CollectFactory;
import edu.najah.cap.data.delete.Delete;
import edu.najah.cap.data.delete.DeleteData;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class GazaStats {
    private final Logger logger = Logger.getLogger(GazaStats.class);
    private final Delete deleteData;
    private final CollectFactory collect_factory;
    private final Addfactory add_factory;
    private final Download download;
    private final CreatePdf create_Pdf;
    private final PDFToZIP pdf_to_ZIP;
    private final IUpload upload;

    public GazaStats(IUserActivityService activity, IPayment payment,
                     IUserService user, IPostService posts) {
        deleteData = new DeleteData(activity, user, posts, payment);
        add_factory = new Addfactory();
        collect_factory = new CollectFactory();
        download = new Download();
        create_Pdf = new CreatePdf();
        pdf_to_ZIP = new PDFToZIP();
        upload = new googleDrive();

    }

    public void addData(Object service, Object data) throws Exception {
        try{
            add_factory.add_data_factory(service, data);
        }catch (RuntimeException err){
            logger.error("System Busy : "+err.getMessage());
            throw new SystemBusyException("Server is busy");
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }


    }

    public <T> Object get_data(String user_id, Object object) throws Exception {
        try {
            return collect_factory.get_data(object, user_id);
        }catch (RuntimeException err){
            logger.error("System Busy : "+err.getMessage());
            throw new SystemBusyException("Server is busy");
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }
    }

    public File get_pdf_file(String user_id, Object service) throws Exception {
        try{
        return create_Pdf.create_pdf(user_id, service);
        }catch (RuntimeException err){
            logger.error("System Busy : "+err.getMessage());
            throw new SystemBusyException("Server is busy");
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }
    }

    public File create_zip_file(File converted_file) throws IOException {
        return pdf_to_ZIP.createZipFile(converted_file);
    }


    public void soft_delete(String userId, String activity_id,
                            String transaction_id,
                            String post_id,
                            String author) throws Exception {
        try {

            deleteData.soft_delete(userId, activity_id, transaction_id, post_id, author);
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }
    }

    public final void hard_delete(String userId, String activity_id,
                                  String transaction_id,
                                  String post_id, String author) throws Exception {
        try {

            deleteData.hard_delete(userId, activity_id, transaction_id, post_id, author);
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }
    }

    public void direct_download(File file, String filename)  {
        try {
            download.downloadFile(file, filename);

        }
        catch (Exception err){
            logger.error("Error : "+ err);
        }
    }

    public void upload_to_storage_file(String file_name, File file) {
        try {
            upload.upload(file_name, file);
        }catch (Exception err){
            logger.error("Error : "+ err);
        }
    }
}

