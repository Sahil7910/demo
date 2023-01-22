package sensedge.server;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {


static Connection con = null;

public static Connection connectDB() throws ClassNotFoundException {

    try {
        // Importing and registering drivers
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3307/demo","root", "admin");
        
        
        
    }
    catch (SQLException e) {

        System.out.println(e);
    }
	return con;
	}
}
