package edu.najah.cap.data.AddData;

import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;

public class AddUser implements IAddData {
    private IUserService user_service;
    public AddUser(IUserService user){
        user_service = user;
    }
    @Override
    public void add_data(Object user_profile) {
        user_service.addUser((UserProfile) user_profile);
    }
}
