package edu.najah.cap.data.AddData;

import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import org.apache.log4j.Logger;

public class AddUser implements IAddData {
    private Logger logger= Logger.getLogger(AddUser.class);
    private IUserService user_service;
    public AddUser(IUserService user){
        user_service = user;
    }
    @Override
    public void add_data(Object user_profile) throws Exception {
        try {
            user_service.addUser((UserProfile) user_profile);
            logger.info("add user data successfully");
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
