package az.azerconnect.testapp.dao;

import az.azerconnect.testapp.model.Payment;

import java.sql.*;

public class PaymentDao {


    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public void connect() throws ClassNotFoundException, SQLException {
        String username="postgres";
        String password="admin";
        String url="jdbc:postgresql://localhost:5432/postgres";
        String driverName="org.postgresql.Driver";
        Class.forName(driverName);
        connection = DriverManager.getConnection(url, username, password);
    }

    public void disConnect() throws SQLException {
        if(resultSet!=null)
            resultSet.close();
        if(preparedStatement!=null)
            preparedStatement.close();
        if(connection!=null)
            connection.close();
    }


    public void save(Payment payment) throws SQLException {
        String sql = "INSERT INTO logs VALUES ('"
                + payment.getType() +
                "', '" + payment.getAmount() + "')";
        preparedStatement = (PreparedStatement) connection.createStatement();
        resultSet = preparedStatement.executeQuery(sql);

        while (resultSet.next()){
            preparedStatement.setString(2, payment.getType());
            preparedStatement.setString(3, String.valueOf(payment.getAmount()));
        }

    }

}
