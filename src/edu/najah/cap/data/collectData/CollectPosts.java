package edu.najah.cap.data.collectData;

import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.Post;

import java.util.List;

public class CollectPosts implements ICollectData<List<Post>>{
    private IPostService postService;
    public CollectPosts(IPostService posts){
        postService = posts;
    }
    @Override
    public List<Post> get_data(String user_id) {
       return postService.getPosts(user_id);
    }
}
