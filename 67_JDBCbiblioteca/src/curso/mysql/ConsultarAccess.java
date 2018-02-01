package curso.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarAccess {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Curso Mañana/Desktop/Northwind.mdb","","");
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from customers");
		
		while (rs.next()) {
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
		}
		
	}

}