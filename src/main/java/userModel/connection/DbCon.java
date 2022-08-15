package userModel.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	public static Connection connection;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{

                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chigozie", "root", "chigozie1993");
                System.out.print("connected");


        return connection;
    }

}
