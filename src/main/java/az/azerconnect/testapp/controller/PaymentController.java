package az.azerconnect.testapp.controller;

import az.azerconnect.testapp.model.Payment;
import az.azerconnect.testapp.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/payment-proxy")
public class PaymentController extends HttpServlet {


    @Inject
    PaymentService paymentService;


    private ObjectMapper mapper = new ObjectMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqBody = IOUtils.toString(req.getReader());
        Payment payment = mapper.readValue(reqBody,Payment.class);
        try {
            paymentService.debt(payment);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
