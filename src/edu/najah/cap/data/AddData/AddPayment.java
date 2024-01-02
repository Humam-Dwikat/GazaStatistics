package edu.najah.cap.data.AddData;

import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.Transaction;
import org.apache.log4j.Logger;

public class AddPayment implements IAddData {
    private final Logger logger = Logger.getLogger(AddPayment.class);
    private final IPayment payment_service;

    AddPayment(IPayment payment) {
        payment_service = payment;
    }

    @Override
    public void add_data(Object transaction) throws Exception {
        try {
            payment_service.pay((Transaction) transaction);
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
