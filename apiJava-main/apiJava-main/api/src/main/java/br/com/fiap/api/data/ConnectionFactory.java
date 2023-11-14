package br.com.fiap.api.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	final static String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final static String USER = "rm99711";
    final static String PASS = "290204";

    public static Connection createConnection() throws SQLException{
    	try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to Oracle database.");
        }
    }
}
