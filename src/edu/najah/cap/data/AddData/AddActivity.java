package edu.najah.cap.data.AddData;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;

public class AddActivity implements IAddData{
    private final IUserActivityService user_Activity_Service;
    public AddActivity(IUserActivityService activityService){
        user_Activity_Service = activityService;
    }
    @Override
    public void add_data(Object userActivity) {
            user_Activity_Service.addUserActivity((UserActivity) userActivity);


    }
}
