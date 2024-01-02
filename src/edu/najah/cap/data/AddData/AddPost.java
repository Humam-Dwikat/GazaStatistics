package edu.najah.cap.data.AddData;

import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.Post;
import org.apache.log4j.Logger;

public class AddPost implements IAddData{
    private Logger logger=Logger.getLogger(AddPost.class);
    private final IPostService post_Service;
    public AddPost(IPostService post){
        post_Service = post;
    }
    @Override
    public void add_data(Object posts) throws Exception {
        try {
            post_Service.addPost((Post) posts);
            logger.info("add post for the user successfully");
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
