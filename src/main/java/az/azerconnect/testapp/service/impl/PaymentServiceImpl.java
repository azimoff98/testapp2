package az.azerconnect.testapp.service.impl;

import az.azerconnect.testapp.dao.PaymentDao;
import az.azerconnect.testapp.model.Payment;
import az.azerconnect.testapp.service.PaymentService;

import javax.inject.Inject;
import java.sql.SQLException;

public class PaymentServiceImpl implements PaymentService {

    @Inject
    private PaymentDao paymentDao;

    public static Integer currentAmount = 0;



    public void debt(Payment payment) throws SQLException, ClassNotFoundException {
        paymentDao.connect();
        if(payment.getType() == "Get"){
            if(currentAmount < payment.getAmount()){
                throw new RuntimeException("Balansinizda Bu Emeliyyati yerine" +
                        " yetirmek uchun kifayet qeder vesait yoxdur");
            }
            currentAmount = currentAmount - payment.getAmount();
        }

        if(payment.getType() == "Add"){
            currentAmount = currentAmount + payment.getAmount();
        }
        paymentDao.save(payment);
        paymentDao.disConnect();

    }

}
