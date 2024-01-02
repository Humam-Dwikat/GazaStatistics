package edu.najah.cap.data.collectData;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;
import org.apache.log4j.Logger;

public class CollectFactory {
    private ICollectData<?> collect_data ;
    private final Logger logger = Logger.getLogger(CollectFactory.class);


    public CollectFactory(){
        collect_data = null;
    }
    public <L> Object get_data(Object object, String user_id) throws Exception {
        try {
            if (object instanceof IUserActivityService) {
                collect_data = new CollectActivity((IUserActivityService) object);
                logger.info("create user activity service to get data");
            } else if (object instanceof IPayment) {
                collect_data = new CollectPaymentData((IPayment) object);
                logger.info("create user Payments service to get data");
            } else if (object instanceof IPostService) {
                collect_data = new CollectPosts((IPostService) object);
                logger.info("create user Posts service to get data");
            } else if (object instanceof IUserService) {
                collect_data = new CollectUserData((IUserService) object);
                logger.info("create user user service to get data");

            }
            logger.info("Get data");
            return collect_data.get_data(user_id);
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

