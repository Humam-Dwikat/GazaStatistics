package edu.najah.cap.data.delete;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivityService;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.PaymentService;
import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.PostService;
import org.apache.log4j.Logger;

public class DeleteData extends Delete{
    Logger logger =Logger.getLogger(DeleteData.class);


    public DeleteData(IUserActivityService activity, IUserService user, IPostService posts, IPayment payment) {
        super(activity, user, posts, payment);
    }

    @Override
    protected void removeUserActivity(String userId, String id) throws Exception {
        try {
            userActivityService.removeUserActivity(userId, id);
            logger.info("Delete activity successfully ");
        }catch (RuntimeException err){
            logger.error("System Busy : "+err.getMessage());
            throw new SystemBusyException("Server is busy");
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }
    }

    @Override
    protected void deleteUser(String userName) throws Exception {
        try {
            userService.deleteUser(userName);
            logger.info("Delete user profile successfully ");
        }catch (RuntimeException err){
            logger.error("System Busy : "+err.getMessage());
            throw new SystemBusyException("Server is busy");
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }
    }

    @Override
    protected void removeTransaction(String userName, String id) throws Exception {
        try {
            paymentService.removeTransaction(userName, id);
            logger.info("Delete transaction successfully");
        }catch (RuntimeException err){
            logger.error("System Busy : "+err.getMessage());
            throw new SystemBusyException("Server is busy");
        }
        catch (Exception err){
            logger.error("Error: " + err);
            throw new Exception("Error");

        }
    }

    @Override
    protected void deletePost(String author, String id) throws Exception {
        try{
            postService.deletePost(author,id);
            logger.info("Delete Post successfully");
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
