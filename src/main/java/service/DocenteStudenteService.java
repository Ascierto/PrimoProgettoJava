package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
