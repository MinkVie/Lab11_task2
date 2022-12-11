package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDBUtil {

    public static Connection openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=HANGKHONG";
            Connection connect= DriverManager.getConnection(connectionUrl,"sa","sapassword");
            return connect;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }


    }


}
