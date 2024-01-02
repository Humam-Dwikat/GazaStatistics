package edu.najah.cap.data.AddData;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.exceptions.SystemBusyException;
import org.apache.log4j.Logger;

public class AddActivity implements IAddData{
    private final Logger logger =Logger.getLogger(AddActivity.class);
    private final IUserActivityService user_Activity_Service;
    public AddActivity(IUserActivityService activityService){
        user_Activity_Service = activityService;
    }
    @Override
    public void add_data(Object userActivity) throws Exception {
        try {
            user_Activity_Service.addUserActivity((UserActivity) userActivity);
            logger.info("add user activity successfully");
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
