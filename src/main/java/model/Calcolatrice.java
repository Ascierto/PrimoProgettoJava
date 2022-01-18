package model;

import model.Calcolatrice;

public class Calcolatrice {
	
	private double a;
	private double b;
	
	public Calcolatrice(double a,double b){
		this.a = a;
		this.b = b;
	}
	
	public double somma() {
		double risultato = a+b;
		return risultato;
	}
	
	public double sottrazione() {
		double risultato = a-b;
		return risultato;
	}
	
	public double moltiplicazione() {
		double risultato = a*b;
		return risultato;
	}
	
	public double divisione() {
		
		double risultato = 0;

		try {
			if(a == 0) {
				throw new Exception("Dividendo uguale a zero...Infinito");
			}
			
			if(b == 0) {
				throw new Exception("Stai provando a dividere per zero");
			}
			risultato = a/b;
			 
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Impossibile dividere per 0");
		}
		
		return risultato;
		
	}
	
	public double operazione(String operazione) {
		
		double risultato = 0;
		switch(operazione) {
		case "+":
			risultato = somma();
			break;
		case "-":
			risultato =sottrazione();
			break;
		case "x":
			risultato = moltiplicazione();
			break;
		case "/":
			risultato = divisione();
			break;
		default:
			System.out.println("Operazione non trovata");
			break;
		}
		
		return risultato;
	}
	

}

