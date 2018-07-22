package az.azerconnect.testapp.service;

import az.azerconnect.testapp.model.Payment;

import java.sql.SQLException;

public interface PaymentService {
        void debt(Payment payment) throws SQLException, ClassNotFoundException;
}
