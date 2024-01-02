package edu.najah.cap.data.AddData;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public class Addfactory {
    IAddData addData ;
    public Addfactory(){
        addData = null;
    }
    public void add_data_factory(Object object,Object data){

        if (object instanceof IUserActivityService){
             addData = new AddActivity((IUserActivityService) object);
        }
        else if (object instanceof IPayment) {
             addData = new AddPayment((IPayment) object);
        }
        else if (object instanceof IPostService) {
             addData = new AddPost((IPostService) object);
        }
        else if (object instanceof IUserService){
             addData = new AddUser((IUserService) object);
        }
        addData.add_data(data);
    }
}
