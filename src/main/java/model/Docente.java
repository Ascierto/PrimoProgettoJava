package model;

public class Docente {
	
	private int id_docente;
	private String name;
	private String surname;
	private String email;
	private String password;
	private int is_admin;
	private int id_studente;
	
	public Docente() {
		
	}
	
	public Docente(String email,String password) {
		this.email = email;
		this.password = password;
	}
	
	public Docente(int id,String name,String surname,String email) {
		this.id_docente = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	public Docente(String name,String surname,String email,String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
	
	public int getId_docente() {
		return id_docente;
	}
	public void setId_docente(int id_docente) {
		this.id_docente = id_docente;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}
	public int getId_studente() {
		return id_studente;
	}
	public void setId_studente(int id_studente) {
		this.id_studente = id_studente;
	}
	@Override
	public String toString() {
		return "Docente [id_docente=" + id_docente + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", is_admin=" + is_admin + ", id_studente=" + id_studente + "]";
	}
	
	
	
	

}
