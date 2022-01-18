package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import service.Driver;

public class Studente {
	
	private int id_studente;
	private String name;
	private String surname;
	private int age;
	
	public Studente(){
		
	}
	
	public Studente(String n,String s,int a,int id){
		this.name = n;
		this.surname = s;
		this.age = a;
		this.id_studente = id;
	}
	

	public int getIdStudente() {
		return id_studente;
	}
	public void setIdStudente(int id) {
		this.id_studente = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Studente [name=" + name + ", surname=" + surname + ", age=" + age
				+ "]";
	}
	


}
