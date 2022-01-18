package service;

import java.sql.*;

/**
 * @author giulianoascierto
 *
 */
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Driver.insertStudent("Pippo", "Neri", 28);
		
		
		
		//Driver.updateStudent(3, "Carlo", "Bianchi", 55);
		
		Driver.deleteStudent(2);
		
		Driver.selectStudents();
		
	
	}
	
	
	//Questo metodo fa l'insert, per l'update e la delete basta solo cambiare la query
	
	public static void insertStudent(String name,String surname, int age) {
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateStudent(int id ,String name,String surname, int age) {
		Connection db = null;
		PreparedStatement prepare = null;
		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "UPDATE studenti SET name = ? ,surname = ?,age = ? WHERE id_studenti = ?";
			
			
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
		}
		
	}
	
	public static void deleteStudent(int id) {
		Connection db = null;
		PreparedStatement prepare = null;
		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "DELETE from studenti WHERE id_studenti=?";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
			
			
			//setto i parametri (dopo quando astrarrò il codice saranno String nome,string cognome...)
			prepare.setInt(1, id);
			
			
			//infine eseguo
			
			prepare.executeUpdate();
			
			System.out.println("Studente Eliminato!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void selectStudents() {
		
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
				System.out.print(result.getInt("id_studenti") + " ");
				System.out.print(result.getString("name")+ " ");
				System.out.print(result.getString("surname")+ " ");
				System.out.print(result.getInt("age"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
