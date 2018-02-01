package curso.mysql;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root","");
		Statement st = con.createStatement();
				
		ResultSet rs = st.executeQuery("select * from libros");
		
		while (rs.next()) {
			System.out.println(rs.getString("titulo"));
			System.out.println(rs.getFloat("precio"));
			System.out.println(rs.getDate("fechapublicacion"));
			
			
		}
		
		
		
		int insertar = st.executeUpdate("insert into libros(titulo, autor, precio, fechapublicacion)values('El quijote', 'autor', '22.00','1995-08-16')");
		System.out.println("fila insertada " + insertar);
		
		
		
		PreparedStatement pstmt = con.prepareStatement("select * from libros where titulo = ?");
		pstmt.setString(1,"El quijote");
		
		ResultSet rs1 = pstmt.executeQuery();
		
		while (rs1.next()) {
			System.out.println(rs1.getString("titulo"));
			System.out.println(rs1.getFloat("precio"));
			System.out.println(rs1.getDate("fechapublicacion"));	
		}
		
		
		
		CallableStatement cstmt = con.prepareCall("call listalibros");
		ResultSet rs2 = cstmt.executeQuery();
		
		while (rs2.next()) {
			System.out.println(rs2.getString("titulo"));
			System.out.println(rs2.getFloat("precio"));
			System.out.println(rs2.getDate("fechapublicacion"));
		}
		
		
		
		CallableStatement cstmt2 = con.prepareCall("call listalibrosporautor(?)");
		cstmt2.setString(1, "Hamlet");
		ResultSet rs3 = cstmt2.executeQuery();
		
		while (rs3.next()) {
			System.out.println(rs3.getString("titulo"));
			System.out.println(rs3.getFloat("precio"));
			System.out.println(rs3.getDate("fechapublicacion"));	
		}
	}

}
