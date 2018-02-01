package curso.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConsultarPostgreSQL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/biblioteca", "postgres","Abc12345");
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from libros");
		
		while (rs.next()) {
			System.out.println(rs.getString("titulo"));
			System.out.println(rs.getFloat("precio"));
			System.out.println(rs.getDate("fechapublicacion"));
		}
		
//		int insertar = st.executeUpdate("insert into libros(id, titulo, autor, precio, fechapublicacion)values(1,'El quijote', 'autor', 22.00,'1995-08-16')");
//		System.out.println("fila insertada " + insertar);
		
		PreparedStatement ps = con.prepareStatement("select * from libros where titulo = 'El quijote'");
		ResultSet rs2 = ps.executeQuery();
		
		while (rs2.next()) {
			System.out.println(rs2.getString("titulo"));
			System.out.println(rs2.getFloat("precio"));
			System.out.println(rs2.getDate("fechapublicacion"));
		}
		
		CallableStatement cs = con.prepareCall("{call listalibros()}");
		ResultSet rs3 = cs.executeQuery();
		
		while (rs3.next()) {
			System.out.println(rs3.getString("titulo"));
			System.out.println(rs3.getFloat("precio"));
			System.out.println(rs3.getDate("fechapublicacion"));
		}
		
		
	}

}
