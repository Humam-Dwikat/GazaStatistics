package edu.najah.cap.data.delete;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivityService;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.PaymentService;
import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.PostService;

public class DeleteData extends Delete{


    public DeleteData(IUserActivityService activity, IUserService user, IPostService posts, IPayment payment) {
        super(activity, user, posts, payment);
    }

    @Override
    protected void removeUserActivity(String userId, String id) {
        userActivityService.removeUserActivity(userId,id);

    }

    @Override
    protected void deleteUser(String userName) {
        userService.deleteUser(userName);
    }

    @Override
    protected void removeTransaction(String userName, String id) {

        paymentService.removeTransaction(userName,id);

    }

    @Override
    protected void deletePost(String author, String id) {
        postService.deletePost(author,id);

    }

}
