package edu.najah.cap.data.AddData;

import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.Transaction;

public class AddPayment implements IAddData {
    private IPayment payment_service;

    AddPayment(IPayment payment) {
        payment_service = payment;
    }

    @Override
    public void add_data(Object transaction) {
        payment_service.pay((Transaction) transaction);

    }
}
