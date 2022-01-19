package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Studente;

public class DocenteStudenteService {
	
	public static void insertStudenteToDocente(int id_docente,int id_studente) throws SQLException {
		
		Connection db = null;
		PreparedStatement prepare = null;
		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "INSERT INTO docenti_studenti(id_docente,id_studente) Values(?,?)";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
			
			
			//setto i parametri (dopo quando astrarrò il codice saranno String nome,string cognome...)
			prepare.setInt(1,id_docente);
			prepare.setInt(2, id_studente);

			
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
	
	public static ArrayList<Studente>  showStudentiDocente(int id_docente) throws SQLException {
		
		Connection db = null;
		PreparedStatement prepare = null;
		ArrayList<Studente> studentiAssoc = new ArrayList<Studente>();
		
		
		try {
			String driver = ("com.mysql.jdbc.Driver");
			Class.forName(driver);
			
			//Creo stringa di connessione
			String url = "jdbc:mysql://localhost:3306/jdbc_test";
			
			//Myconnetto con user e pass
			db = DriverManager.getConnection(url,"root","rootroot");
			
			String query = "SELECT * FROM studenti "
						+ "JOIN docenti_studenti on studenti.id_studente = docenti_studenti.id_studente "
						+ "WHERE id_docente = ?";
			
			
			//preparo la query e la metto senza parametri
			prepare = db.prepareStatement(query);
			
			
			//setto i parametri 
			prepare.setInt(1,id_docente);

			
			//infine eseguo
			
			
			ResultSet result = prepare.executeQuery();
					
			while(result.next()) {
						
				int id_studente = result.getInt("id_studente");
				String name =result.getString("name"); 
				String surname =result.getString("surname");
				int age = result.getInt("age");

				studentiAssoc.add(new Studente(name,surname,age,id_studente));
				
					
			}
			

			
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
		
		return studentiAssoc;
	}

}
