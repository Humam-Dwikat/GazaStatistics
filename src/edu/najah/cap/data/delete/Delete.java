package edu.najah.cap.data.delete;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public abstract class Delete {
    protected IUserActivityService userActivityService ;
    protected IPayment paymentService ;
    protected IUserService userService ;
    protected IPostService postService ;
    public Delete(IUserActivityService activity, IUserService user, IPostService posts, IPayment payment) {
        userService = user;
        userActivityService = activity;
        paymentService = payment;
        postService = posts;
    }
    protected abstract void removeUserActivity(String userId, String id) throws Exception;

    protected abstract void deleteUser(String userName) throws Exception;


    protected abstract void removeTransaction(String userName, String id) throws Exception;
    protected abstract void deletePost(String author, String id) throws Exception;

    public final void soft_delete(String userId, String activity_id,
                                  String transaction_id,
                                  String post_id,
                                  String author) throws Exception {
        removeUserActivity(userId,activity_id);
        removeTransaction(userId,transaction_id);
        deletePost(author,post_id);
    };
    public final void hard_delete(String userId, String activity_id,
                                  String transaction_id,
                                  String post_id,
                                  String author) throws Exception {
        soft_delete(userId, activity_id,
                transaction_id,
                post_id,
                author);
        deleteUser(userId);
    }



}
