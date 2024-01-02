package edu.najah.cap.data.collectData;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public class CollectFactory {
    ICollectData<?> collect_data ;

    public CollectFactory(){
        collect_data = null;
    }
    public <L> Object get_data(Object object, String user_id){

        if (object instanceof IUserActivityService){
            collect_data = new CollectActivity((IUserActivityService) object);
        }
        else if (object instanceof IPayment) {
            collect_data = new CollectPaymentData((IPayment) object);
        }
        else if (object instanceof IPostService) {
            collect_data = new CollectPosts((IPostService) object);
        }
        else if (object instanceof IUserService){
            collect_data = new CollectUserData((IUserService) object);
        }
        return collect_data.get_data(user_id);
    }
}

