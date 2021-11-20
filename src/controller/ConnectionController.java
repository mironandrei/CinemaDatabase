package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionController {

    private Connection connection;

    private ConnectionController(){
        //connection on xampp controller
        String url = "jdbc:mysql://localhost:3306/examenjavap";

        try {
            connection = DriverManager.getConnection(url,"root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static final class SingletonHolder{
        private static final ConnectionController instance = new ConnectionController();

    }

    public static ConnectionController getInstance(){
        return SingletonHolder.instance;
    }

    public Connection getConnection(){
        return this.connection;
    }
}
