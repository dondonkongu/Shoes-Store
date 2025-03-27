package context;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:sqlserver://DESKTOP-E5VCDRF\\SQLEXPRESS01:1433;databaseName=webbanhang;";
		String user = "sa";
		String password = "123456";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	

		
}
