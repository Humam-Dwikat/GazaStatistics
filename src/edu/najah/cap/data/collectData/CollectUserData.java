package edu.najah.cap.data.collectData;

import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import org.apache.log4j.Logger;

public class CollectUserData implements ICollectData <UserProfile>{
    private final Logger logger = Logger.getLogger(CollectActivity.class);
    private final IUserService userService;
    public CollectUserData(IUserService user){
        userService = user;
    }
    @Override
    public UserProfile get_data(String user_id) throws Exception {
        try {
            logger.info("Get user data successfully");
            return userService.getUser(user_id);
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
