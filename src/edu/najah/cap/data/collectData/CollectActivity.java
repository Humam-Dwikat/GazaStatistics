package edu.najah.cap.data.collectData;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;

import java.util.List;

class CollectActivity implements ICollectData<List<UserActivity>> {
    private IUserActivityService userActivityService;
    public CollectActivity(IUserActivityService user_activity){
        userActivityService=user_activity;
    }
    @Override
    public List<UserActivity> get_data(String user_id) {

        return userActivityService.getUserActivity(user_id);
    }
}
