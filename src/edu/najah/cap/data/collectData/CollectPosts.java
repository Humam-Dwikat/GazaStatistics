package edu.najah.cap.data.collectData;

import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.Post;
import org.apache.log4j.Logger;

import java.util.List;

public class CollectPosts implements ICollectData<List<Post>>{
    private Logger logger =Logger.getLogger(CollectPosts.class);
    private final IPostService postService;
    public CollectPosts(IPostService posts){
        postService = posts;
    }
    @Override
    public List<Post> get_data(String user_id) throws Exception {
        try {
            logger.info("Get posts successfully");
            return postService.getPosts(user_id);
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
