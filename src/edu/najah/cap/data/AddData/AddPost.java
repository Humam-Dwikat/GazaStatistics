package edu.najah.cap.data.AddData;

import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.Post;

public class AddPost implements IAddData{
    private IPostService post_Service;
    public AddPost(IPostService post){
        post_Service = post;
    }
    @Override
    public void add_data(Object posts) {
        post_Service.addPost((Post) posts);
    }
}
