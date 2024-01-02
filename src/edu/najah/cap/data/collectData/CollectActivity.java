package edu.najah.cap.data.collectData;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.exceptions.SystemBusyException;
import org.apache.log4j.Logger;

import java.util.List;

class CollectActivity implements ICollectData<List<UserActivity>> {
    private Logger logger = Logger.getLogger(CollectActivity.class);
    private IUserActivityService userActivityService;
    public CollectActivity(IUserActivityService user_activity){
        userActivityService=user_activity;
    }
    @Override
    public List<UserActivity> get_data(String user_id) throws Exception {
        try {
            logger.info("Get Activities successfully");
            return userActivityService.getUserActivity(user_id);
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
