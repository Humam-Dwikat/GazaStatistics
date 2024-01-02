package edu.najah.cap.data.collectData;

import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.Transaction;
import org.apache.log4j.Logger;

import java.util.List;

public class CollectPaymentData implements ICollectData<List<Transaction>>{
    private final Logger logger = Logger.getLogger(CollectActivity.class);
    private final IPayment payment_service;
    public CollectPaymentData(IPayment payment){
        payment_service = payment;
    }
    @Override
    public List<Transaction> get_data(String user_id) throws Exception {
        try {
            logger.info("Get Transactions successfully");
            return payment_service.getTransactions(user_id);
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
