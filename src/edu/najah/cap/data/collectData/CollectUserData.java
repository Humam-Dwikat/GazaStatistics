package edu.najah.cap.data.collectData;

import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;

public class CollectUserData implements ICollectData <UserProfile>{
    private IUserService userService;
    public CollectUserData(IUserService user){
        userService = user;
    }
    @Override
    public UserProfile get_data(String user_id) {
        return userService.getUser(user_id);
    }
}
