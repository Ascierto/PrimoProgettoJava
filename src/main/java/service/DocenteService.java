package service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Docente;
import model.Studente;

public class DocenteService {
	
	

	public static void insertDocente(String name,String surname, String email,String password) throws SQLException {
		Connection db = null;
		PreparedStatement prepare = null;
		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "INSERT INTO docenti(name,surname,email,password) Values(?,?,?,MD5(?))";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
			
			
			//setto i parametri (dopo quando astrarrò il codice saranno String nome,string cognome...)
			prepare.setString(1,name);
			prepare.setString(2, surname);
			prepare.setString(3, email);
			prepare.setString(4, password);
			
			//infine eseguo
			
			prepare.executeUpdate();
			
			System.out.println("Inserimento Riuscito!");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
		
			if(prepare != null) {
				prepare.close();
			}
			
			if(db != null) {
				db.close();
			}
		}
		
	}
	

	
	public static Docente loginDocente(String em,String pass) throws SQLException {
		
		Connection db = null;
		PreparedStatement prepare = null;
		Docente docente = new Docente();
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "SELECT * from docenti WHERE email=? AND password=MD5(?)";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
			prepare.setString(1,em);
			prepare.setString(2,pass);
				
			//infine eseguo
			
			
			
			ResultSet result = prepare.executeQuery();
			
			
			if(result.next()) {
				int id_docente = result.getInt("id_docente");
				String name =result.getString("name"); 
				String surname =result.getString("surname"); 
				String email =result.getString("email"); 
				
				docente = new Docente(id_docente,name,surname,email);
			}else {
				docente = null;
			}
			

			

			
			
		}catch(Exception e) {
			e.printStackTrace();
	
		}finally {
		
			if(prepare != null) {
				prepare.close();
			}
			
			if(db != null) {
				db.close();
			}
		}
	
		return docente;
	}
		
		
		
}
