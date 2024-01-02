package edu.najah.cap.data.collectData;

import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.Transaction;

import java.util.List;

public class CollectPaymentData implements ICollectData<List<Transaction>>{
    private IPayment payment_service;
    public CollectPaymentData(IPayment payment){
        payment_service = payment;
    }
    @Override
    public List<Transaction> get_data(String user_id) {
        return payment_service.getTransactions(user_id);
    }
}
