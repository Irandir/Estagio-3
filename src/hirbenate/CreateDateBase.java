package hirbenate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class CreateDateBase {
	public static final String HOST = "jdbc:postgresql://localhost:5432/";
	public void create() {
		Connection conexao;
	
		try {
			conexao = DriverManager.getConnection(HOST,"postgres","root");
			Statement stmt = conexao.createStatement();
			stmt.executeUpdate("CREATE DATABASE banco2");
			stmt.executeUpdate("CREATE USER java_user WITH PASSWORD  \'java\'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
}
