package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Studente;

public class StudenteService {

	//Questo metodo fa l'insert, per l'update e la delete basta solo cambiare la query
	public static void insertStudent(String name,String surname, int age) throws SQLException {
		Connection db = null;
		PreparedStatement prepare = null;
		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "INSERT INTO studenti(name,surname,age) Values(?,?,?)";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
			
			
			//setto i parametri (dopo quando astrarrò il codice saranno String nome,string cognome...)
			prepare.setString(1,name);
			prepare.setString(2, surname);
			prepare.setInt(3, age);
			
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
	
	public static void updateStudent(int id ,String name,String surname, int age) throws SQLException {
		Connection db = null;
		PreparedStatement prepare = null;
		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "UPDATE studenti SET name = ? ,surname = ?,age = ? WHERE id_studente = ?";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
			
			
			//setto i parametri (dopo quando astrarrò il codice saranno String nome,string cognome...)
			prepare.setString(1,name);
			prepare.setString(2, surname);
			prepare.setInt(3, age);
			prepare.setInt(4, id);
			
			
			//infine eseguo
			
			prepare.executeUpdate();
			
			System.out.println("Update andata a buon fine!");
			
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
		
	}
	
	public static void deleteStudent(int id) throws SQLException {
		Connection db = null;
		PreparedStatement prepare = null;
		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "DELETE from studenti WHERE id_studente=?";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
			
			
			//setto i parametri (dopo quando astrarrò il codice saranno String nome,string cognome...)
			prepare.setInt(1, id);
			
			
			//infine eseguo
			
			prepare.executeUpdate();
			
			System.out.println("Studente Eliminato!");
			
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
		
	}
	
	public static ArrayList<Studente> selectAllStudents() throws SQLException {
		
		Connection db = null;
		PreparedStatement prepare = null;
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		
		

		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "SELECT * from studenti";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
			
				
			//infine eseguo
			
			
			
			ResultSet result = prepare.executeQuery();
					
			while(result.next()) {
						
				int id_studente = result.getInt("id_studente");
				String name =result.getString("name"); 
				String surname =result.getString("surname");
				int age = result.getInt("age");

				studenti.add(new Studente(name,surname,age,id_studente));
				
					
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
	
		return studenti;
	}
	
	public static void selectStudents() throws SQLException {
		
		Connection db = null;
		PreparedStatement prepare = null;
		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "SELECT * from studenti";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
				
			//infine eseguo
			
			
			
			ResultSet result = prepare.executeQuery();
			
			
			while(result.next()) {
				System.out.println();
				System.out.print(result.getInt("id_studente") + " ");
				System.out.print(result.getString("name")+ " ");
				System.out.print(result.getString("surname")+ " ");
				System.out.print(result.getInt("age"));
				
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
		
	}
	
	public static Studente selectOneStudent(int id) throws SQLException {
		
		Connection db = null;
		PreparedStatement prepare = null;
		Studente studente = new Studente();
		
		

		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "SELECT * from studenti WHERE id_studente=?";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
			prepare.setInt(1, id);
				
			//infine eseguo
			
			
			
			ResultSet result = prepare.executeQuery();
			
			
			if(result.next()) {
				int id_studente = result.getInt("id_studente");
				String name =result.getString("name"); 
				String surname =result.getString("surname");
				int age = result.getInt("age");
				studente = new Studente(name,surname,age,id_studente);
			}else {
				studente = null;
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
	
		return studente;
	}
}
