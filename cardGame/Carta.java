package cardGame;

import java.util.ArrayList;

public class Carta {
	String nombre;
	ArrayList<Atributo> atributos;
	Pocion pocima;
	
	public Carta() {
		atributos = new ArrayList();
		this.pocima = null;
	}
	
	
	public void agregarAtributo(Atributo a) {
		this.atributos.add(a);
	}
	
	public String getNombreCarta() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre; 
	}
	
	public ArrayList<Atributo> getAtributos() {
		ArrayList<Atributo> aux = new ArrayList();
		for(int i = 0; i < this.atributos.size(); i++) {
			aux.add(this.atributos.get(i));
		}
				
		return aux;
	}
	
	public Atributo getAtributo(String atributo) {
		
		for(int i= 0; i < atributos.size(); i++) {
			if(atributos.get(i).getNombre().equals(atributo)) 
				return atributos.get(i);
			
		}
		
		
		
		
		return null; //aca hacer el efecto de la pocion 
	}
	
	public int getCantAtr() {
		return atributos.size();
	}
	

	
	public ArrayList<String> getNombresAtributos(){
		ArrayList<String> aux = new ArrayList();
		for(int i = 0; i < this.atributos.size(); i++) {
			aux.add(this.atributos.get(i).getNombre());
		}
		return aux;
	}

	public void agregarPocima(Pocion p){
		this.pocima = p;
	}

	public Pocion getPocima(){
		return this.pocima;
	}

	public boolean tienePocima(){
		if (pocima == null)
			return false;
		else
			return true;
	}

	public int getAtrConPocion(String atr){
		Atributo atri = new Atributo();
		atri = this.getAtributo(atr);

		return this.pocima.efecto(atri);
	}

	@Override
	
	public String toString() {
		
		return this.nombre + " " +this.getAtributos() + " " + this.getPocima();
	}
	
	
	
	
}
