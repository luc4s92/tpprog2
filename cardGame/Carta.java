package cardGame;

import java.util.ArrayList;

public class Carta {
	private String nombre;
	private  ArrayList<Atributo> atributos;
	private Pocion pocima;
	
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
		if(this.tienePocima()) {
			return this.pocima.efecto(atri);
		}

		return atri.getValor();
	}
	
	
	public String imprimirCartaJuego(String atributoJugable) {
        String resultado = "";
        resultado = " es " + this.getNombreCarta() + " con " + atributoJugable + " " + this.getAtributo(atributoJugable).getValor();
        if (this.tienePocima()) {
            resultado = resultado + ", se aplicó pocima " + this.getPocima().getNombre() + " valor resultante " + this.getAtrConPocion(atributoJugable);
        }
        return resultado;
    }

	
	//comparacion entre una carta y otra
	
	public int compararCartas(Carta carta, String nombreAtr) {
		Integer atrValor1 = this.getAtrConPocion(nombreAtr);
		Integer atrValor2 = carta.getAtrConPocion(nombreAtr);
		return atrValor1.compareTo(atrValor2);
	}
	
	
	
	

	@Override
	
	public String toString() {
		
		return this.nombre + " " +this.getAtributos() + " " + this.getPocima();
	}
	
	
	
	
}
