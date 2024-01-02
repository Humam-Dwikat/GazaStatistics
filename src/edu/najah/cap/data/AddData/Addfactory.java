package edu.najah.cap.data.AddData;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;
import org.apache.log4j.Logger;

public class Addfactory {
    private final Logger logger = Logger.getLogger(Addfactory.class);
    private IAddData addData ;
    public Addfactory(){
        addData = null;
    }
    public void add_data_factory(Object object,Object data) throws Exception {
        try {

            if (object instanceof IUserActivityService){
                 addData = new AddActivity((IUserActivityService) object);
                 logger.info("Create Activity Service to add data");
            }
            else if (object instanceof IPayment) {
                 addData = new AddPayment((IPayment) object);
                 logger.info("Create Payment service to add data");
            }
            else if (object instanceof IPostService) {
                 addData = new AddPost((IPostService) object);
                 logger.info("Create Post Service to add data");
            }
            else if (object instanceof IUserService){
                 addData = new AddUser((IUserService) object);
                 logger.info("Create User Service to add data");
            }
            logger.info("data added successfully");
            addData.add_data(data);
        }catch (RuntimeException err){
            logger.error("System Busy : "+err.getMessage());
            throw new SystemBusyException("Server is busy");
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }
}}
